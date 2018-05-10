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

package org.md2k.utilities.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.md2k.utilities.Constants;
import org.md2k.utilities.R;

/**
 * Creates an activity to tell the user about the application.
 */
public class ActivityAbout extends AppCompatActivity {
    private static final String TAG = ActivityAbout.class.getSimpleName();

    /**
     * Calls <code>setButtons()</code> on activity creation.
     * @param savedInstanceState Previous state of the application if available.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        if(getIntent().getStringExtra(Constants.VERSION_NAME) != null)
            ((TextView)findViewById(R.id.textView_version))
                    .setText(getIntent().getStringExtra(Constants.VERSION_NAME) + " (" + getIntent()
                            .getStringExtra(Constants.VERSION_CODE) + ")");
        setButtons();
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Creates a "Close" button.
     */
    void setButtons(){
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setText("Close");
        button1.setOnClickListener(new View.OnClickListener() {
            /**
             * Closes the activity when pressed.
             * @param v Button to be pressed.
             */
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * Handles the selection of items on the action bar.
     *
     * <p>
     *     Handle action bar item clicks here. The action bar will automatically handle clicks on
     *     the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
     * </p>
     *
     * @param item Android MenuItem object
     * @return False to allow normal menu processing to proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
