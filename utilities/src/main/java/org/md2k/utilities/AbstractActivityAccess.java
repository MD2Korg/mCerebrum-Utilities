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

package org.md2k.utilities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.md2k.utilities.permission.ObservablePermission;

import rx.Observer;
import rx.Subscription;

/**
 *
 */
public abstract class AbstractActivityAccess extends AppCompatActivity {
    public static final String SETTINGS = "settings";
    public static final String IS_VALID_SETTINGS = "is_valid_settings";
    public static final String SET_DEFAULT = "set_default_settings";
    public static final String CLEAR_ALL = "clear_all";
    public static final String CLEAR_SETTINGS = "clear_settings";
    public static final String CLEAR_DATA = "clear_data";
    public static final String OPERATION = "operation";
    public static final String RESULT = "result";
    public static final String PERMISSION = "permission";
    public static final int REQ_CODE = 1;
    Subscription subsPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String operation = getIntent().getStringExtra(OPERATION);
        performOperation(operation);
    }

    void getPermission() {
        subsPermission = ObservablePermission.get(this).subscribe(new Observer<Boolean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                sendResult(false);
            }

            @Override
            public void onNext(Boolean aBoolean) {
                sendResult(aBoolean);
                subsPermission.unsubscribe();
            }
        });
    }

    @Override
    public void onDestroy() {
        if (subsPermission != null && !subsPermission.isUnsubscribed())
            subsPermission.unsubscribe();
        super.onDestroy();
    }

    public void sendResult(boolean result) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(RESULT, result);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    public abstract boolean isValidSettings();

    public abstract boolean settings();

    public abstract boolean setDefault();

    public abstract boolean clearSettings();

    public abstract boolean clearData();

    public abstract boolean clear_all();

    public void performOperation(String operation) {
        switch (operation) {
            case SETTINGS:
                settings();
                break;
            case IS_VALID_SETTINGS:
                sendResult(isValidSettings());
                break;
            case SET_DEFAULT:
                sendResult(setDefault());
                break;
            case CLEAR_SETTINGS:
                sendResult(clearSettings());
                break;
            case CLEAR_ALL:
                sendResult(clear_all());
                break;
            case CLEAR_DATA:
                sendResult(clearData());
                break;
            case PERMISSION:
                getPermission();
                break;
        }
    }
}
