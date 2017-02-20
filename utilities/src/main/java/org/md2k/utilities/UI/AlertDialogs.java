package org.md2k.utilities.UI;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatTextView;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.md2k.utilities.R;

/*
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
public class AlertDialogs {
    private static AlertDialog alertDialog;
    private static int selected;

/*
    public static void showAlertDialogDataKit(final Context context){
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle("Error: DataKit")
//                .setIcon(R.drawable.ic_error_outline_white_24dp)
                .setMessage("DataKit is not installed.\n\n Please install DataKit")
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create();

        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
    public static void showAlertDialog(final Context context, String title, String message){
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setIcon(R.drawable.ic_error_red_50dp)
                .setMessage(message)
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
    public static void showAlertDialogConfirm(final Context context, String title, String message, String positive, String negative,final DialogInterface.OnClickListener onClickListener){
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setIcon(R.drawable.ic_info_teal_48dp)
                .setMessage(message)
                .setNegativeButton(negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onClickListener.onClick(dialog,which);
                    }
                })
                .setPositiveButton(positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onClickListener.onClick(dialog,which);
                    }
                })
                .create();
        int titleDividerId = context.getResources().getIdentifier("titleDivider", "id", "android");
        View titleDivider = alertDialog.findViewById(titleDividerId);
        if (titleDivider != null)
            titleDivider.setBackgroundColor(context.getResources().getColor(R.color.deeporange_A400));

        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
*/
    public static void AlertDialogStyle(Context context, AlertDialog alertDialog){
        int titleDividerId = alertDialog.getContext().getResources().getIdentifier("titleDivider", "id", "android");
        View titleDivider = alertDialog.getWindow().getDecorView().findViewById(titleDividerId);
        if (titleDivider != null) {
            titleDivider.setBackgroundColor(ContextCompat.getColor(context, R.color.deeporange_100));
            titleDivider.setVisibility(View.VISIBLE);
        }
        int textViewId = alertDialog.getContext().getResources().getIdentifier("android:id/alertTitle", null, null);
        TextView tv = (TextView) alertDialog.findViewById(textViewId);
        tv.setTextColor(ContextCompat.getColor(context, R.color.teal_700));

        int textViewMsgId = alertDialog.getContext().getResources().getIdentifier("android:id/message", null, null);
        TextView tvMsg = (TextView) alertDialog.findViewById(textViewMsgId);
        if(tvMsg!=null) {
            tvMsg.setTextSize(16);
            tvMsg.setGravity(Gravity.CENTER);
            tvMsg.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
        Button b = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        if(b != null){
            b.setTextColor(ContextCompat.getColor(context, R.color.teal_700));
            b.setTypeface(null, Typeface.BOLD);
        }
        b = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        if(b != null){
            b.setTextColor(ContextCompat.getColor(context, R.color.teal_700));
            b.setTypeface(null, Typeface.BOLD);
        }
        b = alertDialog.getButton(DialogInterface.BUTTON_NEUTRAL);
        if(b != null){
            b.setTextColor(ContextCompat.getColor(context, R.color.teal_700));
            b.setTypeface(null, Typeface.BOLD);
        }

    }

    public static void AlertDialog(final Context context, String title, String message, int iconId, String positive, String negative,String neutral, final DialogInterface.OnClickListener onClickListener){
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.app_theme_teal_light_dialog))
                .setTitle(title)
                .setIcon(iconId)
                .setMessage(message);
        if(positive!=null)
            alertDialogBuilder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onClickListener.onClick(dialog,which);
                }
            });
        if(negative!=null)
                alertDialogBuilder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onClickListener.onClick(dialog,which);
                    }
                });
        if(neutral!=null){
            alertDialogBuilder.setNeutralButton(neutral, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onClickListener.onClick(dialog,which);
                }
            });

        }
        alertDialog=alertDialogBuilder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
        AlertDialogStyle(context, alertDialog);
    }
    public static void AlertDialog(final Context context, String title, String message, Drawable iconDrawable, String positive, String negative, String neutral, final DialogInterface.OnClickListener onClickListener){
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.app_theme_teal_light_dialog))
                .setTitle(title)
                .setIcon(iconDrawable)
                .setMessage(message);
        if(positive!=null)
            alertDialogBuilder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onClickListener.onClick(dialog,which);
                }
            });
        if(negative!=null)
            alertDialogBuilder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onClickListener.onClick(dialog,which);
                }
            });
        if(neutral!=null){
            alertDialogBuilder.setNeutralButton(neutral, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onClickListener.onClick(dialog,which);
                }
            });

        }
        alertDialog=alertDialogBuilder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
        AlertDialogStyle(context, alertDialog);
    }

    public static void AlertDialogEditText(final Context context, String title, String message, int iconId, String positive, String negative, final OnClickListener onClickListener){
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.app_theme_teal_light_dialog))
                .setTitle(title)
                .setIcon(iconId)
                .setMessage(message);
        final EditText input = new EditText(context);
        input.setSingleLine();
        alertDialogBuilder.setView(input);

        if(positive!=null)
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String str = input.getText().toString().trim();
                    onClickListener.onClick(dialog,which, str);
                }
            });
        if(negative!=null)
            alertDialogBuilder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onClickListener.onClick(dialog,which, null);
                }
            });
        alertDialog=alertDialogBuilder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
        alertDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        AlertDialogStyle(context, alertDialog);
    }

    public static void AlertDialogSingleChoice(final Context context, String title, String[] strings, int curSelected, String positive, String negative,final DialogInterface.OnClickListener onClickListener){
        selected=curSelected;
        alertDialog = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.app_theme_teal_light_dialog))
                .setTitle(title)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        onClickListener.onClick(dialog, -1);
                    }
                })
                .setNegativeButton(negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onClickListener.onClick(dialog,-1);
                    }
                })
                .setPositiveButton(positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setSingleChoiceItems(strings, curSelected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        selected=which;
                    }
                })
                .create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(selected!=-1) {
                    onClickListener.onClick(null, selected);
                    alertDialog.dismiss();
                }
            }
        });
        AlertDialogStyle(context, alertDialog);
    }
}
