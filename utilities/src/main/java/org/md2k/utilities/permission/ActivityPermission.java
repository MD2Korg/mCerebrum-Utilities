package org.md2k.utilities.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;


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

public class ActivityPermission extends Activity {
    private static final String TAG = ActivityPermission.class.getSimpleName();
    private static final int RESULT_MANAGE_OVERLAY_PERMISSION = 5469;
    private static final int RESULT_PERMISSION = 5470;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            close(true);
        } else {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, RESULT_MANAGE_OVERLAY_PERMISSION);
            } else {
                String list[]=PermissionInfo.getList(this);
                if (list != null)
                    requestPermissions(list, RESULT_PERMISSION);
                else
                    close(true);
            }
        }
    }

    void close(boolean result) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(PermissionInfo.INTENT_RESULT,result);
        setResult(Activity.RESULT_OK, resultIntent);
        Intent intent = new Intent(PermissionInfo.INTENT_PERMISSION);
        intent.putExtra(PermissionInfo.INTENT_PERMISSION_RESULT, result);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        finish();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_MANAGE_OVERLAY_PERMISSION) {
            if (Settings.canDrawOverlays(this)) {
                String[] p = PermissionInfo.getList(getApplicationContext());
                if(p==null || p.length==0)
                    close(true);
                else
                requestPermissions(PermissionInfo.getList(getApplicationContext()), RESULT_PERMISSION);
            }
            else
                close(false);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        boolean flag = true;
        switch (requestCode) {
            case RESULT_PERMISSION: {
                if (grantResults.length == 0) flag = false;
                else {
                    for (int grantResult : grantResults) {
                        if (grantResult == PackageManager.PERMISSION_DENIED) {
                            flag = false;
                            break;
                        }
                    }
                }
                close(flag);
            }
        }
    }
}
