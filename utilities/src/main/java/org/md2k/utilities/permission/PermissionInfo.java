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

/**
 * Array of permissions that are considered dangerous.
 * <p>
 *     The following permissions are considered dangerous.
 *     <uL>
 *         <li><code>ACCESS_COURSE_LOCATION</code></li>
 *         <li><code>ACCESS_FINE_LOCATION</code></li>
 *         <li><code>bODY_SENSORS</code></li>
 *         <li><code>CALL_PHONE</code></li>
 *         <li><code>CAMERA</code></li>
 *         <li><code>GET_ACCOUNTS</code></li>
 *         <li><code>PROCESS_OUTGOING_CALLS</code></li>
 *         <li><code>READ_CALENDAR</code></li>
 *         <li><code>READ_CALL_LOG</code></li>
 *         <li><code>READ_CELL_BROADCASTS</code></li>
 *         <li><code>READ_CONTACTS</code></li>
 *         <li><code>READ_EXTERNAL_STORAGE</code></li>
 *         <li><code>READ_PHONE_STATE</code></li>
 *         <li><code>READ_SMS</code></li>
 *         <li><code>RECEIVE_MMS</code></li>
 *         <li><code>RECEIVE_SMS</code></li>
 *         <li><code>RECEIVE_WAP_PUSH</code></li>
 *         <li><code>RECORD_AUDIO</code></li>
 *         <li><code>SEND_SMS</code></li>
 *         <li><code>USE_SIP</code></li>
 *         <li><code>WRITE_CALENDAR</code></li>
 *         <li><code>WRITE_CALL_LOG</code></li>
 *         <li><code>WRITE_CONTACTS</code></li>
 *         <li><code>WRITE_EXTERNAL_STORAGE</code></li>
 *         <li><code>ADD_VOICEMAIL</code></li>
 *     </uL>
 * </p>
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

    /** Constant used for logging. <p>Uses <code>class.getSimpleName()</code>.</p> */
    private static final String TAG = PermissionInfo.class.getSimpleName();

    /** String constant for permission intents. */
    public static final String INTENT_PERMISSION = "intent_permission";

    /** String constant for permission intent results. */
    public static final String INTENT_PERMISSION_RESULT = "intent_permission_result";

    /** Result callback interface instance. */
    ResultCallback<Boolean> resultCallback;

    /**
     * Checks if permissions are granted, and asks for them if not.
     * @param context Android context
     * @param resultCallback Callback interface.
     */
    public void getPermissions(Context context, ResultCallback<Boolean> resultCallback) {
        this.resultCallback = resultCallback;
        if (isGranted(context))
            resultCallback.onResult(true);
        else {
            LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(INTENT_PERMISSION));
            Intent intent = new Intent(context, ActivityPermission.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        /**
         * Passes the received result to <code>resultCallback</code> and unregisters the receiver.
         * @param context Android context
         * @param intent
         */
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean result = intent.getBooleanExtra(INTENT_PERMISSION_RESULT, false);
            resultCallback.onResult(result);
            LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
        }
    };

    /**
     * Determines if the required permissions have been granted.
     * @param context Android context
     * @return Whether the required permissions have been granted.
     */
    public static boolean isGranted(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(context)) return false;
            if (getList(context) != null) return false;
        }
        return true;
    }

    /**
     * Returns a list of permissions that were denied and dangerous.
     * @param context Android context
     * @return An array of permissions that were denied and dangerous.
     */
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

    /**
     * Determines if the given permission is in the dangerous permissions list.
     * @param permission Permission to check.
     * @return Whether the given permission is dangerous or not.
     */
    private static boolean isDangerous(String permission) {
        for (String PERMISSION_DANGEROUS : PermissionInfo.PERMISSION_DANGEROUS)
            if (PERMISSION_DANGEROUS.equals(permission))
                return true;
        return false;
    }
}
