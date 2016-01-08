package org.md2k.utilities.datakit;

import android.content.Context;

import org.md2k.datakitapi.DataKitApi;
import org.md2k.datakitapi.datatype.DataType;
import org.md2k.datakitapi.datatype.DataTypeString;
import org.md2k.datakitapi.messagehandler.OnConnectionListener;
import org.md2k.datakitapi.messagehandler.OnReceiveListener;
import org.md2k.datakitapi.source.application.ApplicationBuilder;
import org.md2k.datakitapi.source.datasource.DataSource;
import org.md2k.datakitapi.source.datasource.DataSourceBuilder;
import org.md2k.datakitapi.source.datasource.DataSourceClient;
import org.md2k.datakitapi.source.datasource.DataSourceType;
import org.md2k.datakitapi.source.platform.Platform;
import org.md2k.datakitapi.source.platform.PlatformBuilder;
import org.md2k.datakitapi.source.platform.PlatformType;
import org.md2k.datakitapi.status.Status;
import org.md2k.datakitapi.time.DateTime;
import org.md2k.utilities.Report.Log;

import java.util.ArrayList;

/**
 * Copyright (c) 2015, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * All rights reserved.
 * <p/>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <p/>
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * <p/>
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <p/>
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
public class DataKitHandler {
    private static final String TAG = DataKitHandler.class.getSimpleName();
    DataKitApi dataKitApi;
    Context context;
    boolean connected;
    DataSourceClient dataSourceClient;
    private static DataKitHandler instance=null;
    private OnConnectionListener callerOnConnectedListener;
    public static DataKitHandler getInstance(Context context){
        if(instance==null){
            instance=new DataKitHandler(context);
        }
        return instance;
    }
    public boolean isConnected(){
        return connected;
    }
    private DataKitHandler(Context context){
        Log.d(TAG,"DataKitHandler()...constructor()");
        this.context=context;
        connected=false;
        dataKitApi = new DataKitApi(context);
    }
    OnConnectionListener onConnectionListener=new OnConnectionListener() {
        @Override
        public void onConnected() {
            connected=true;
            Platform platform=new PlatformBuilder().setType(PlatformType.PHONE).build();
            dataSourceClient=register(new DataSourceBuilder().setType(DataSourceType.LOG).setPlatform(platform));
            callerOnConnectedListener.onConnected();
        }
    };
    public void log(String message){
        DataTypeString dataTypeString=new DataTypeString(DateTime.getDateTime(),message);
        insert(dataSourceClient,dataTypeString);
    }
    public boolean connect(OnConnectionListener callerOnConnectionListener) {
        if(isConnected()) {
            callerOnConnectionListener.onConnected();
            return true;
        }
        Log.d(TAG,"connect()...");
        this.callerOnConnectedListener = callerOnConnectionListener;
        return dataKitApi.connect(onConnectionListener);
    }
    public ArrayList<DataSourceClient> find(DataSourceBuilder dataSourceBuilder){
        return dataKitApi.find(dataSourceBuilder).await();
    }
    public void insert(DataSourceClient dataSourceClient, DataType data){
        dataKitApi.insert(dataSourceClient, data);
    }
    public DataSourceClient register(DataSourceBuilder dataSourceBuilder){
        Log.d(TAG, "register()...");
        return dataKitApi.register(dataSourceBuilder).await();
    }
    public Status unregister(DataSourceClient dataSourceClient){
        Log.d(TAG, "register()...");
        return dataKitApi.unregister(dataSourceClient).await();
    }

    public ArrayList<DataType> query(DataSourceClient dataSourceClient, int last_n_sample){
        return dataKitApi.query(dataSourceClient, last_n_sample).await();
    }
    public ArrayList<DataType> query(DataSourceClient dataSourceClient, long starttimestamp,long endtimestamp){
        return dataKitApi.query(dataSourceClient,starttimestamp,endtimestamp).await();
    }
    public void subscribe(DataSourceClient dataSourceClient, OnReceiveListener onReceiveListener){
        dataKitApi.subscribe(dataSourceClient,onReceiveListener);
    }
    public Status unsubscribe(DataSourceClient dataSourceClient){
        return dataKitApi.unsubscribe(dataSourceClient).await();
    }

    public void disconnect(){
        Log.d(TAG,"disconnect()...");
        dataKitApi.disconnect();
        connected=false;
    }
    public void close(){
        Log.d(TAG,"close()...");
        instance=null;
    }
}
