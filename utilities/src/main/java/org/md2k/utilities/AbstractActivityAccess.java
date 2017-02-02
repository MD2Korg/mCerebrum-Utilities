package org.md2k.utilities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.md2k.utilities.permission.ObservablePermission;

import rx.Observer;
import rx.Subscription;

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
    public static final int REQ_CODE=1;
    Subscription subsPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_abstract_access);
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
