package org.md2k.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.md2k.datakitapi.source.datasource.DataSource;
import org.md2k.utilities.Report.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
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
        if (file.exists())
            return true;
        return false;
    }

    public static ArrayList<DataSource> readDataSourceFromFile(String filename) throws FileNotFoundException {
        ArrayList<DataSource> dataSources=null;
        Log.d(TAG, "readDataSourceFromFile()" + filename);
        if (!isExist(filename)) throw new FileNotFoundException();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Gson gson = new Gson();
        Type collectionType = new TypeToken<List<DataSource>>() {
        }.getType();
        dataSources = gson.fromJson(br, collectionType);
        return dataSources;
    }
    public static void writeDataSourceToFile(String directory, String filename, ArrayList<DataSource> dataSources) throws IOException {
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Gson gson = new Gson();
        String json = gson.toJson(dataSources);
        FileWriter writer = new FileWriter(directory + File.separator + filename);
        writer.write(json);
        writer.close();
    }
}
