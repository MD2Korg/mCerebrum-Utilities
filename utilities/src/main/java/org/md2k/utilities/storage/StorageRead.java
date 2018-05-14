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

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for reading and opening file paths.
 */
public abstract class StorageRead {
    protected Context context;

    /**
     * Constructor
     * @param context Android context
     */
    StorageRead(Context context){
        this.context = context;
    }

    /**
     * Opens the given file path in an <code>InputStream</code>.
     * @param filePath File path to open.
     * @return The resulting <code>InputStream</code>.
     */
    abstract protected InputStream open(String filePath);

    /**
     * Returns whether the given file path exists.
     * @param filePath The file path to check for.
     * @return Whether the given file path exists.
     */
    abstract public boolean isExist(String filePath);

    /**
     * Returns whether a file path exists.
     * @return Whether a file path exists.
     */
    abstract public boolean isExist();


    /**
     * Reads a json file and returns the data.
     * @param filePath Path to the json file.
     * @param classType Class that defines the object or data contained in the json file.
     * @param <T> Formal generic.
     * @return The data or object from the json file.
     */
    public <T> T readJson(String filePath, Class<T> classType) {
        T data = null;
        BufferedReader reader = null;
        try {
            InputStream in = open(filePath);
            if(in == null)
                throw new Exception("File not found");
            reader = new BufferedReader(new InputStreamReader(in));
            Gson gson = new Gson();
            data = gson.fromJson(reader, classType);
        } catch (Exception e) {
            data = null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }
        return data;
    }

    /**
     * Reads a json file and returns the data in an arrayList.
     * @param filePath Path to the json file.
     * @param classType Class that defines the object or data contained in the json file.
     * @param <T>
     * @return The data or object from the json file in an arrayList.
     */
    public <T> ArrayList<T> readJsonArrayList(String filePath, Class<T> classType) {
        ArrayList<T> data = null;
        BufferedReader reader = null;
        try {
            InputStream in = open(filePath);
            if(in == null)
                return null;
            reader = new BufferedReader(new InputStreamReader(in));
            Gson gson = new Gson();
            data = gson.fromJson(reader,new ListOfSomething<>(classType));
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }
        return data;
    }

    /**
     * Returns
     * @param context Android context
     * @param storageType
     * @return
     */
    public static StorageRead get(Context context, StorageType storageType){
        switch (storageType){
            case ASSET:return new StorageAsset(context);
            case SDCARD_APPLICATION: return new StorageApplication(context);
            case SDCARD_INTERNAL: return new StorageSDCardInternal(context);
            case SDCARD_EXTERNAL: return new StorageSDCardExternal(context);
            case SDCARD_EXTERNAL_PREFERRED: return new StorageSDCardExternalPreferred(context);
        }
        return null;
    }

    /**
     * Nested class for creating a list of class types and arguments.
     * @param <X> Formal generic.
     */
    private class ListOfSomething<X> implements ParameterizedType {
        private Class<?> wrapped;

        /**
         * Constructor
         * @param wrapped Class to list things about.
         */
        ListOfSomething(Class<X> wrapped) {
            this.wrapped = wrapped;
        }

        /**
         * Returns the type arguments.
         * @return An array of type arguments.
         */
        public java.lang.reflect.Type[] getActualTypeArguments() {
            return new java.lang.reflect.Type[]{wrapped};
        }

        /**
         * Returns the raw type.
         * @return List.
         */
        public java.lang.reflect.Type getRawType() {
            return List.class;
        }

        /**
         * Returns the owner type.
         * @return Always returns null.
         */
        public java.lang.reflect.Type getOwnerType() {
            return null;
        }
    }
}
