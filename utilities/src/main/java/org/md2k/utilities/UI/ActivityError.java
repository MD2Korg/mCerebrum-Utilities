package org.md2k.utilities.UI;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import org.md2k.utilities.R;

public class ActivityError extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        alertDialog.setTitle(getIntent().getStringExtra("title"));
        alertDialog.setMessage(getIntent().getStringExtra("message"));
        alertDialog.setIcon(R.drawable.ic_error_black_48dp);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });
        alertDialog.show();
    }
}
