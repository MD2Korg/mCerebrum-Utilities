package org.md2k.utilities;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.os.StatFs;

import com.google.gson.Gson;

import org.md2k.utilities.Report.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
 * Copyright (c) 2015, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
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
public class FileManager {
    private static final String TAG = FileManager.class.getSimpleName();
    public static final String INTERNAL_SDCARD = "INTERNAL_SDCARD";
    public static final String EXTERNAL_SDCARD = "EXTERNAL_SDCARD";
    public static final String EXTERNAL_SDCARD_PREFERRED = "EXTERNAL_SDCARD_PREFERRED";
    public static final String INTERNAL_SDCARD_PREFERRED = "INTERNAL_SDCARD_PREFERRED";
    public static final String NONE = "NONE";
    private static String getInternalSDCardDirectory(Context context) {
        String directory = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            directory = Environment.getExternalStorageDirectory().toString() + "/Android/data/" + context.getPackageName() + "/files/";
            File dir = new File(directory);
            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    directory = null;
                }
            }
        }
        return directory;
    }
    private static String getExternalSDCardDirectory(Context context) {
        String strSDCardPath = System.getenv("SECONDARY_STORAGE");
        File[] externalFilesDirs = context.getExternalFilesDirs(null);
        for (File externalFilesDir : externalFilesDirs) {
            if (externalFilesDir == null) continue;
            if (externalFilesDir.getAbsolutePath().contains(strSDCardPath))
                return externalFilesDir.getAbsolutePath()+File.separator;
        }
        return null;
    }
    public static String getLocationType(Context context, String option){
        switch (option) {
            case INTERNAL_SDCARD:
                if(getInternalSDCardDirectory(context)==null) return null;
                else return INTERNAL_SDCARD;
            case EXTERNAL_SDCARD:
                if(getExternalSDCardDirectory(context)==null) return null;
                else return EXTERNAL_SDCARD;
            case INTERNAL_SDCARD_PREFERRED:
                if(getInternalSDCardDirectory(context)==null) return null;
                else return INTERNAL_SDCARD;
            case EXTERNAL_SDCARD_PREFERRED:
                if(getExternalSDCardDirectory(context)!=null) return EXTERNAL_SDCARD;
                else if(getInternalSDCardDirectory(context)!=null) return INTERNAL_SDCARD;
                else return null;
            case NONE:
                return null;
            default:
                return null;
        }
    }
    public static String getDirectory(Context context, String option) {
        if (context == null) return null;
        Log.d(TAG, "getDirectory.. STORAGE_OPTION=" + option + " Context=" + context);
        String directory;
        switch (option) {
            case INTERNAL_SDCARD:
                directory = getInternalSDCardDirectory(context);
                break;
            case EXTERNAL_SDCARD:
                directory = getExternalSDCardDirectory(context);
                break;
            case INTERNAL_SDCARD_PREFERRED:
                directory = getInternalSDCardDirectory(context);
                break;
            case EXTERNAL_SDCARD_PREFERRED:
                directory = getExternalSDCardDirectory(context);
                if (directory == null)
                    directory = getInternalSDCardDirectory(context);
                break;
            case NONE:
                directory = null;
                break;
            default:
                directory = null;
        }
        return directory;
    }
    public static boolean isExist(String filename) {
        File file = new File(filename);
        return file.exists();
    }
    public static void deleteDirectory(String directory){
        deleteRecursive(new File(directory));
    }
    private static void deleteRecursive(File fileOrDirectory) {

        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }
    public static <T> ArrayList<T> readJSONArray(String directory, String filename, Class<T> classType) throws FileNotFoundException {
        ArrayList<T> dataSources;
        if (!isExist(directory+filename)) throw new FileNotFoundException();
        BufferedReader br = new BufferedReader(new FileReader(directory+filename));
        Gson gson = new Gson();
        dataSources = gson.fromJson(br, new ListOfSomething<>(classType));
        return dataSources;
    }
    public static <T> T readJSON(String directory, String filename, Class<T> classType) throws FileNotFoundException {
        T data;
        if (!isExist(directory+filename)) throw new FileNotFoundException();
        BufferedReader br = new BufferedReader(new FileReader(directory+filename));
        Gson gson = new Gson();
        data = gson.fromJson(br, classType);
        return data;
    }
    public static <T> void writeJSONArray(String directory, String filename, ArrayList<T> data) throws IOException {
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Gson gson = new Gson();
        String json = gson.toJson(data);
        Log.d(TAG,json);
        FileWriter writer = new FileWriter(directory + filename);
        writer.write(json);
        writer.close();
    }
    public static <T> void writeJSON(String directory, String filename, T data) throws IOException {
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Gson gson = new Gson();
        String json = gson.toJson(data);
        Log.d(TAG,json);
        FileWriter writer = new FileWriter(directory + filename);
        writer.write(json);
        writer.close();
    }
    public static boolean deleteFile(String filename){
        File file=new File(filename);
        return file.delete();
    }
    public static String getSDCardSizeString(Context context, String STORAGE_OPTION) {
        String sdCard = getLocationType(context, STORAGE_OPTION);
        long available=0, total=0, used=0;
        String totalStr = "-", usedStr="-";
        if (sdCard.equals(INTERNAL_SDCARD)) {
            available = getAvailableSDCardSize(Environment.getExternalStorageDirectory().getAbsolutePath());
            total = getTotalSDCardSize(Environment.getExternalStorageDirectory().getAbsolutePath());
            used=total-available;
            usedStr=formatSize(used);
            totalStr=formatSize(total);
        } else if (sdCard.equals(EXTERNAL_SDCARD)) {
            available = getAvailableSDCardSize(getExternalSDCardDirectory(context));
            total = getTotalSDCardSize(getExternalSDCardDirectory(context));
            used=total-available;
            totalStr=formatSize(total);
            usedStr=formatSize(used);

        }
        return usedStr + " out of " + totalStr + " ( "+String.valueOf(used*100/total)+"% )";
    }
    static class ListOfSomething<X> implements ParameterizedType {

        private Class<?> wrapped;

        public ListOfSomething(Class<X> wrapped) {
            this.wrapped = wrapped;
        }

        public Type[] getActualTypeArguments() {
            return new Type[] {wrapped};
        }

        public Type getRawType() {
            return List.class;
        }

        public Type getOwnerType() {
            return null;
        }
    }
    public static long getFileSize(Context context, String STORAGE_OPTION){
        String path=getDirectory(context, STORAGE_OPTION);

        File file=new File(path);
        long fileSize=0;
        if(file.exists())
            fileSize=file.length();
        return fileSize;
    }
    public static long getAvailableSDCardSize(String path) {
        StatFs stat = new StatFs(path);
        long blockSize = stat.getBlockSizeLong();
        long remainingBlocks = stat.getFreeBlocksLong();
        return remainingBlocks * blockSize;
    }
    public static long getTotalSDCardSize(String path) {
        StatFs stat = new StatFs(path);
        long blockSize = stat.getBlockSizeLong();
        long totalBlocks = stat.getBlockCountLong();
        return totalBlocks * blockSize;
    }
    public static String formatSize(long size) {
        String suffix = null;
        if (size >= 1024) {
            suffix = " KB";
            size /= 1024;
            if (size >= 1024) {
                suffix = " MB";
                size /= 1024;
            }
        }

        StringBuilder resultBuffer = new StringBuilder(Long.toString(size));

        int commaOffset = resultBuffer.length() - 3;
        while (commaOffset > 0) {
            resultBuffer.insert(commaOffset, ',');
            commaOffset -= 3;
        }

        if (suffix != null) resultBuffer.append(suffix);
        return resultBuffer.toString();
    }
    public static void createDir(File dir) {
        if (dir.exists()) {
            return;
        }
        Log.d(TAG, "Creating dir " + dir.getName());
        if (!dir.mkdirs()) {
            throw new RuntimeException("Cannot create dir " + dir);
        }
    }
    public static void unzip(String tempFileName, String destinationPath) {
        try {
            int index = destinationPath.lastIndexOf("/");
            String fileString = destinationPath.substring(index);

            File extFile = new File(fileString);
            if(!extFile.exists()) {
                createDir(extFile);
            }

            byte[] buffer = new byte[1024];

            FileInputStream fin = new FileInputStream(tempFileName);
            ZipInputStream zin = new ZipInputStream(fin);
            ZipEntry zipentry = null;
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

                    String fileName = destinationPath + zipName;
                    fileName = fileName.replace("\\", "/");
                    fileName = fileName.replace("//", "/");

                    if (zipentry.isDirectory()) {
                        createDir(new File(fileName));
                        continue;
                    }

                    String name = zipentry.getName();
                    int start, end = 0;
                    while (true) {

                        start = name.indexOf('\\', end);
                        end = name.indexOf('\\', start + 1);
                        if (start > 0)
                            "check".toString();
                        if (end > start && end > -1 && start > -1) {
                            String dir = name.substring(1, end);

                            createDir(new File(destinationPath + '/' + dir));
                            // name = name.substring(end);
                        } else
                            break;
                    }

                    File file = new File(fileName);

                    FileOutputStream tempDexOut = new FileOutputStream(file);
                    int BytesRead = 0;

                    if (zipentry != null) {
                        if (zin != null) {
                            while ((BytesRead = zin.read(buffer)) != -1) {
                                tempDexOut.write(buffer, 0, BytesRead);
                            }
                            tempDexOut.flush();
                            tempDexOut.close();
                            Log.d(TAG,"filename="+file.getAbsolutePath()+" name="+file.getName()+" size="+file.length());
                        }
                    }
                }
            }

        } catch (Exception e) {
            Log.e("Exception", e.getMessage());
        }
    }
    public static boolean copyAssets(Context context, String filename, String destination) {
        AssetManager assetManager = context.getAssets();
            InputStream in = null;
            OutputStream out = null;
            try {
                createDir(new File(destination));
                in = assetManager.open(filename);
                File outFile = new File(destination+"/"+filename);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
            } catch(IOException e) {
                return false;
            }
            finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        return false;
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        return false;
                    }
                }
            }
        return true;
    }
    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}
