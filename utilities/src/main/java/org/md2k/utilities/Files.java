package org.md2k.utilities;

import com.google.gson.Gson;

import org.md2k.utilities.Report.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by smh on 5/20/2015.
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
