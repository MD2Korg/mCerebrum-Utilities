package org.md2k.utilities.permission;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;

import org.md2k.datakitapi.messagehandler.ResultCallback;

import java.util.ArrayList;

import rx.Observable;

/**
 * Copyright (c) 2016, The University of Memphis, MD2K Center
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
public class PermissionInfo {
    public static final String INTENT_RESULT="result";
    public static final String[] PERMISSION_DANGEROUS = {
            "android.permission.ACCESS_COARSE_LOCATION",
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.BODY_SENSORS",
            "android.permission.CALL_PHONE",
            "android.permission.CAMERA",
            "android.permission.GET_ACCOUNTS",
            "android.permission.PROCESS_OUTGOING_CALLS",
            "android.permission.READ_CALENDAR",
            "android.permission.READ_CALL_LOG",
            "android.permission.READ_CELL_BROADCASTS",
            "android.permission.READ_CONTACTS",
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.READ_PHONE_STATE",
            "android.permission.READ_SMS",
            "android.permission.RECEIVE_MMS",
            "android.permission.RECEIVE_SMS",
            "android.permission.RECEIVE_WAP_PUSH",
            "android.permission.RECORD_AUDIO",
            "android.permission.SEND_SMS",
            "android.permission.USE_SIP",
            "android.permission.WRITE_CALENDAR",
            "android.permission.WRITE_CALL_LOG",
            "android.permission.WRITE_CONTACTS",
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "com.android.voicemail.permission.ADD_VOICEMAIL"
    };

    private static final String TAG = PermissionInfo.class.getSimpleName();
    public static final String INTENT_PERMISSION = "intent_permission";
    public static final String INTENT_PERMISSION_RESULT = "intent_permission_result";
    ResultCallback<Boolean> resultCallback;


    public void getPermissions(Context context, ResultCallback<Boolean> resultCallback) {
        this.resultCallback = resultCallback;
        if (isGranted(context))
            resultCallback.onResult(true);
        else {
            LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(INTENT_PERMISSION));
            Intent intent = new Intent(context, ActivityPermission.class);
            context.startActivity(intent);
        }
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean result = intent.getBooleanExtra(INTENT_PERMISSION_RESULT, false);
            LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
            resultCallback.onResult(result);
        }
    };

    public static boolean isGranted(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(context)) return false;
            if (getList(context) != null) return false;
        }
        return true;
    }

    public static String[] getList(Context context) {
        ArrayList<String> list = new ArrayList<>();
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            for (String aList : info.requestedPermissions) {
                if (ContextCompat.checkSelfPermission(context, aList) == PackageManager.PERMISSION_DENIED && isDangerous(aList))
                    list.add(aList);
            }
        } catch (Exception ignored) {
        }
        if (list.size() == 0) return null;
        String listArray[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            listArray[i] = list.get(i);
        return listArray;
    }

    private static boolean isDangerous(String permission) {
        for (String PERMISSION_DANGEROUS : PermissionInfo.PERMISSION_DANGEROUS)
            if (PERMISSION_DANGEROUS.equals(permission))
                return true;
        return false;
    }
}
