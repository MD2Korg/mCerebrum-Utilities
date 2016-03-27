package org.md2k.utilities;

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
public class Files {
    private static final String TAG = Files.class.getSimpleName();

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
    public static boolean delete(String filename){
        File file=new File(filename);
        return file.delete();
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

}
