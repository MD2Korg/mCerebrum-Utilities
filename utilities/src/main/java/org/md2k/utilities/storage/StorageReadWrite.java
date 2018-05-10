/*
 * Copyright (c) 2018, The University of Memphis, MD2K Center of Excellence
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.md2k.utilities.storage;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.StatFs;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Provides methods for reading and writing to storage
 */
public abstract class StorageReadWrite extends StorageRead {

    /**
     * Constructor
     * @param context Android context
     */
    StorageReadWrite(Context context) {
        super(context);
    }

    /**
     * Returns whether the root directory exists.
     * @return Whether the root directory exists.
     */
    @Override
    public boolean isExist() {
        return getRootDirectory() != null;
    }

    /**
     * Returns the path to the root directory.
     * @return The path to the root directory.
     */
    protected abstract String getRootDirectory();


    /**
     * Returns whether the given file path exists.
     * @param filePath The file path to check for.
     * @return Whether the given file path exists.
     */
    @Override
    public boolean isExist(String filePath) {
        try {
            String fullPath = getFullPath(filePath);
            if (fullPath == null) return false;
            else {
                File file = new File(fullPath);
                return file.exists();
            }
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Creates a directory with the given name.
     * @param name Name of new directory.
     * @return Whether the new directory exists or not.
     */
    public boolean createDirectory(String name) {
        try {
            String fullPath = getFullPath(name);
            if (fullPath == null)
                throw new Exception("SDCard Not exist");
            String directoryName = getDirectoryName(fullPath);
            File f = new File(directoryName);
            return f.exists() || f.mkdirs();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns the directory name at the end of the given path.
     * @param fullPath Path to extract the directory name from.
     * @return The directory name at the end of the given path.
     */
    private String getDirectoryName(String fullPath){
        if(fullPath.endsWith(File.separator))
            return fullPath;
        int ind = fullPath.lastIndexOf(File.separator);
        if(ind == -1)
            return fullPath;
        else
            return fullPath.substring(0, ind + 1);
    }

    /**
     * Returns the total about of space the storage has in bytes.
     * @return The total about of space the storage has in bytes.
     */
    public long totalSpace() {
        if (!isExist())
            return 0;
        return new StatFs(getRootDirectory()).getTotalBytes();
    }

    /**
     * Returns the amount of free space the storage has in bytes.
     * @return The amount of free space the storage has in bytes.
     */
    public long freeSpace() {
        if (!isExist())
            return 0;
        return new StatFs(getRootDirectory()).getAvailableBytes();
    }

    /**
     * Returns the amount of used space.
     * @return The amount of used space.
     */
    public long usedSpace() {
        return totalSpace() - freeSpace();
    }

    /**
     * Deletes the given file.
     * @param filePath File path to delete.
     * @return Whether the deletion was successful.
     */
    public boolean deleteFile(String filePath) {
        try {
            String fullPath = getFullPath(filePath);
            if (fullPath == null)
                throw new Exception("Not exist");
            if (isExist(fullPath)) {
                File file = new File(fullPath);
                return file.delete();
            } else
                return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Deletes the given directory.
     * @param directoryName Path to the directory to delete.
     * @return Whether the operation was successful or not.
     */
    public boolean deleteDirectory(String directoryName) {
        try {
            String fullPath = getFullPath(directoryName);
            if (fullPath == null)
                throw new Exception("SDCard not exists");
            return deleteRecursive(new File(fullPath));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Deletes the given file or directory recursively.
     * @param fileOrDirectory File or directory to delete.
     * @return Whether the operation was successful.
     */
    private boolean deleteRecursive(File fileOrDirectory) {
        boolean result = true;
        try {
            if (fileOrDirectory.isDirectory())
                for (File child : fileOrDirectory.listFiles())
                    result &= deleteRecursive(child);
            result &= fileOrDirectory.delete();
            return result;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Returns the full path to the given file path.
     * @param filePath File path to find full path for.
     * @return The full path to the given file path.
     */
    private String getFullPath(String filePath) {
        String fullPath = getRootDirectory();
        if (fullPath == null)
            return null;
        return fullPath + filePath;
    }

    /**
     * Opens the given file path in an <code>FileInputStream</code>.
     * @param filePath File path to open.
     * @return The resulting <code>FileInputStream</code>.
     */
    @Override
    protected FileInputStream open(String filePath) {
        try {
            String fullPath = getFullPath(filePath);
            if (fullPath == null)
                throw new Exception("SDCard not exist");
            return new FileInputStream(fullPath);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Opens the given file path in an <code>InputStream</code>.
     * @param fromStorageType Storage type the file is stored on.
     * @param fromFilePath File path to open.
     * @return The resulting <code>InputStream</code>.
     */
    private InputStream open(StorageType fromStorageType, String fromFilePath) {
        InputStream in;
        switch (fromStorageType) {
            case ASSET:
                in = new StorageAsset(context).open(fromFilePath);
                break;
            case SDCARD_APPLICATION:
                in = new StorageSDCardInternal(context).open(fromFilePath);
                break;
            case SDCARD_INTERNAL:
                in = new StorageSDCardInternal(context).open(fromFilePath);
                break;
            case SDCARD_EXTERNAL:
                in = new StorageSDCardExternal(context).open(fromFilePath);
                break;
            case SDCARD_EXTERNAL_PREFERRED:
                in = new StorageSDCardExternalPreferred(context).open(fromFilePath);
                break;
            default:
                in = null;
        }
        return in;
    }

    /**
     * Writes the input file to the output location.
     * @param fromStorageType Type of storage the input file is on.
     * @param fromFilePath File path of the input file.
     * @param toFilePath File path to write the file to.
     * @return Whether the operation was successful.
     */
    public boolean write(StorageType fromStorageType, String fromFilePath, String toFilePath) {
        InputStream in;
        FileOutputStream out;
        if (!isExist())
            return false;
        boolean success = true;
        try {
            String fullPath = getFullPath(toFilePath);
            if (fullPath == null)
                throw new Exception("Not exist");
            if (!createDirectory(toFilePath))
                throw new Exception("Can't create directory");
            in = open(fromStorageType, fromFilePath);
            out = new FileOutputStream(fullPath);
            if (!copyBytes(in, out))
                throw new Exception("Write fails");
        } catch (Exception e) {
            success = false;
        }
        return success;
    }

    /**
     * Copies the <code>InputStream</code> to the <code>OutputStream</code>.
     * @param in Input
     * @param out Output
     * @return Whether the operation was successful.
     */
    private boolean copyBytes(InputStream in, OutputStream out) {
        try {
            if (in == null || out == null)
                return false;
            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Writes an arrayList of data to a json file.
     * @param filePath File path to the new json file.
     * @param data ArrayList of data to write.
     * @param <T> Formal generic.
     * @return Whether the operation was successful.
     */
    public <T> boolean writeJsonArray(String filePath, ArrayList<T> data) {
        boolean result = true;
        FileWriter writer = null;
        try {
            String fullPath = getFullPath(filePath);
            if (fullPath == null) throw new Exception("Not exist");
            else {
                if (!createDirectory(filePath)) result = false;
                else {
                    Gson gson = new Gson();
                    String json = gson.toJson(data);
                    writer = new FileWriter(fullPath);
                    writer.write(json);
                }
            }
        } catch (Exception e) {
            result = false;
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Writes an object or data to a json file.
     * @param filePath File path to the new json file.
     * @param data Object or data to write.
     * @param <T> Formal generic.
     * @return Whether the operation was successful.
     */
    public <T> boolean writeJson(String filePath, T data) {
        boolean result = true;
        FileWriter writer = null;
        try {
            String fullPath = getFullPath(filePath);
            if (fullPath == null)
                throw new Exception("Not exist");
            else {
                if (!createDirectory(filePath)) result = false;
                else {
                    Gson gson = new Gson();
                    String json = gson.toJson(data);
                    writer = new FileWriter(fullPath);
                    writer.write(json);
                }
            }
        } catch (Exception e) {
            result = false;
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Unzips a zip archive.
     * @param fromStorageType Type of storage the zip archive is on.
     * @param fromFilePath File path the zip archive is stored at.
     * @param toFilePath File path to unzip the archive to.
     * @return Whether the unzipping was successful.
     */
    public boolean unzip(StorageType fromStorageType, String fromFilePath, String toFilePath) {
        try {
            if (toFilePath == null)
                throw new Exception("Not exist");
            if (!createDirectory(toFilePath))
                throw new Exception("Can't create directory");
            InputStream in = open(fromStorageType, fromFilePath);
            byte[] buffer = new byte[1024];
            ZipInputStream zin = new ZipInputStream(in);
            ZipEntry zipentry;
            if (!(zin.available() == 0)) {
                while ((zipentry = zin.getNextEntry()) != null) {
                    String zipName = zipentry.getName();
                    if (zipName.startsWith("/")) {
                        zipName = zipentry.getName();
                    } else if (zipName.startsWith("\\")) {
                        zipName = zipentry.getName();
                    } else {
                        zipName = "/" + zipentry.getName();
                    }
                    String fileName = toFilePath + zipName;
                    fileName = fileName.replace("\\", "/");
                    fileName = fileName.replace("//", "/");
                    if (zipentry.isDirectory()) {
                        if (!createDirectory(fileName))
                            return false;
                        continue;
                    }
                    String name = zipentry.getName();
                    int start, end = 0;
                    while (true) {
                        start = name.indexOf('\\', end);
                        end = name.indexOf('\\', start + 1);
                        if (end > start && end > -1 && start > -1) {
                            String dir = name.substring(1, end);
                            if (!createDirectory(toFilePath + dir))
                                return false;
                        } else
                            break;
                    }
                    File file = new File(getFullPath(fileName));
                    FileOutputStream tempDexOut = new FileOutputStream(file);
                    int BytesRead;
                    while ((BytesRead = zin.read(buffer)) != -1) {
                        tempDexOut.write(buffer, 0, BytesRead);
                    }
                    tempDexOut.flush();
                    tempDexOut.close();
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Returns a <code>StorageRead</code> object of the specified type.
     * @param context Android context
     * @param storageType Type of storage to use.
     * @return A <code>StorageRead</code> object of the specified type.
     */
    public static StorageRead get(Context context, StorageType storageType) {
        switch (storageType) {
            case SDCARD_APPLICATION:
                return new StorageApplication(context);
            case SDCARD_INTERNAL:
                return new StorageSDCardInternal(context);
            case SDCARD_EXTERNAL:
                return new StorageSDCardExternal(context);
            case SDCARD_EXTERNAL_PREFERRED:
                return new StorageSDCardExternalPreferred(context);
        }
        return null;
    }
}
