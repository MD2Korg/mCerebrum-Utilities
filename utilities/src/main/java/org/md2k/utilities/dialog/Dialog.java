package org.md2k.utilities.dialog;
/*
 * Copyright (c) 2016, The University of Memphis, MD2K Center
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

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import org.md2k.utilities.R;
import org.md2k.utilities.icons.Icon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Dialog {
    public static final int BUTTON_POSITIVE = 0;
    public static final int BUTTON_NEGATIVE = 1;
    public static final int BUTTON_NEUTRAL = 2;
    private DatePicker datePicker;

    public MaterialDialog.Builder SingleChoice(Context context, String title, String content, String[] items, String selectedItem,String[] buttonText, Drawable icon, final DialogCallback dialogCallback){
        MaterialDialog.Builder materialDialogBuilder=setDefault(context,title, content,buttonText, icon, dialogCallback);
        int selected=0;
        for(int i=0;i<items.length && selectedItem!=null;i++)
            if(items[i].equals(selectedItem))
                selected=i;
        List<String> list = Arrays.asList(items);
        CharSequence[] cs = list.toArray(new CharSequence[list.size()]);
        materialDialogBuilder=materialDialogBuilder.items(cs)
                .itemsCallbackSingleChoice(selected, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        dialogCallback.onDialogCallback(DialogResponse.POSITIVE,new String[]{text.toString()});
                        return true;
                    }
                });
        return materialDialogBuilder;
    }
    public MaterialDialog.Builder ProgressIndeterminate(Context context, String title, String content){
        return new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .progress(true, 0);
    }
    public MaterialDialog.Builder EditText(Context context, String title, String content, String hint, String selectedText, Drawable icon, final DialogCallback dialogCallback){
        MaterialDialog.Builder materialDialogBuilder=setDefault(context, title, content, new String[]{"Ok", "Cancel"}, icon, new DialogCallback() {
            @Override
            public void onDialogCallback(DialogResponse which, String[] result) {
                if(which==DialogResponse.POSITIVE){

                }else{
                    dialogCallback.onDialogCallback(which, null);
                }
            }
        });
        materialDialogBuilder = materialDialogBuilder.inputType(InputType.TYPE_CLASS_TEXT)
                .input(hint, selectedText, false, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        dialogCallback.onDialogCallback(DialogResponse.POSITIVE,new String[]{input.toString()});
                    }
                });
        return materialDialogBuilder;
    }
    public MaterialDialog.Builder Error(Context context, String title, String content, String[] buttonText, final DialogCallback dialogCallback) {
        MaterialDialog.Builder materialDialogBuilder=setDefault(context,title, content, buttonText, Icon.get(context,Icon.Id.ERROR_CIRCLE, Color.parseColor("#F44336"), Icon.Size.SMALL), dialogCallback);
        materialDialogBuilder=materialDialogBuilder.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialogCallback.onDialogCallback(DialogResponse.POSITIVE, null);
            }
        });
        return materialDialogBuilder;
    }
    public MaterialDialog.Builder Info(Context context, String title, String content, String[] buttonText, final DialogCallback dialogCallback) {
        MaterialDialog.Builder materialDialogBuilder =setDefault(context,title, content, buttonText,Icon.get(context,Icon.Id.INFO_CIRCLE, Color.parseColor("#03A9F4"), Icon.Size.SMALL), dialogCallback);
        materialDialogBuilder=materialDialogBuilder.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialogCallback.onDialogCallback(DialogResponse.POSITIVE,null);
            }
        });
        return materialDialogBuilder;
    }
    public MaterialDialog.Builder MultiChoice(Context context, String title, String content, String[] items, Drawable icon, final DialogCallback dialogCallback) {
        MaterialDialog.Builder materialDialogBuilder =setDefault(context,title, content, new String[]{"Select","Cancel",null}, icon, dialogCallback);
        List<String> list = Arrays.asList(items);
        CharSequence[] cs = list.toArray(new CharSequence[list.size()]);

        materialDialogBuilder=materialDialogBuilder.items(cs)
                .itemsCallbackMultiChoice(null, new MaterialDialog.ListCallbackMultiChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                        dialogCallback.onDialogCallback(DialogResponse.POSITIVE, (String[]) text);
                        return true;
                    }
                });
        return materialDialogBuilder;
    }
    public MaterialDialog.Builder Question(Context context, String title, String content, String[] buttonText, final DialogCallback dialogCallback) {
        MaterialDialog.Builder materialDialogBuilder =setDefault(context,title, content, buttonText,Icon.get(context,Icon.Id.QUESTION_CIRCLE, Color.parseColor("#2196F3"), Icon.Size.SMALL), dialogCallback);
        materialDialogBuilder=materialDialogBuilder.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialogCallback.onDialogCallback(DialogResponse.POSITIVE,null);
            }
        });
        return materialDialogBuilder;
    }
    public MaterialDialog.Builder DialogSuccess(Context context, String title, String content, String[] buttonText, final DialogCallback dialogCallback) {
        MaterialDialog.Builder materialDialogBuilder =setDefault(context,title, content, buttonText,Icon.get(context,Icon.Id.SUCCESS_CIRCLE, Color.parseColor("#4CAF50"), Icon.Size.SMALL), dialogCallback);
        materialDialogBuilder=materialDialogBuilder.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialogCallback.onDialogCallback(DialogResponse.POSITIVE,null);
            }
        });
        return materialDialogBuilder;
    }
    private TimePicker timePicker;
    public MaterialDialog TimePicker(Context context, String title, String selectedTime, Drawable icon, final DialogCallback dialogCallback) {
        MaterialDialog.Builder materialDialogBuilder =setDefault(context, title, null, new String[]{"Select", "Cancel", null}, icon, dialogCallback);

        materialDialogBuilder = materialDialogBuilder.customView(R.layout.dialog_timepicker, false)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        int hour = timePicker.getCurrentHour();
                        int minute = timePicker.getCurrentMinute();
                        String timeString = String.format(Locale.US, "%02d:%02d:00", hour, minute);
                        System.out.println("Time = "+ timeString);
                        dialogCallback.onDialogCallback(DialogResponse.POSITIVE, new String[]{timeString});

                    }
                });
        MaterialDialog materialDialog = materialDialogBuilder.build();
        timePicker = (TimePicker) materialDialog.findViewById(R.id.timePicker);
        return materialDialog;
    }
    public MaterialDialog.Builder DialogWarning(Context context, String title, String content, String[] buttonText, final DialogCallback dialogCallback) {
        MaterialDialog.Builder materialDialogBuilder =setDefault(context,title, content, buttonText,Icon.get(context,Icon.Id.WARNING_TRIANGLE, Color.parseColor("#FF9800"), Icon.Size.SMALL), dialogCallback);
        materialDialogBuilder=materialDialogBuilder.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialogCallback.onDialogCallback(DialogResponse.POSITIVE,null);
            }
        });
        return materialDialogBuilder;
    }

    public MaterialDialog DatePicker(Context context, String title, String selectedTime, Drawable icon, final DialogCallback dialogCallback) {
        MaterialDialog.Builder materialDialogBuilder= setDefault(context, title, null, new String[]{"Select", "Cancel", null}, icon, dialogCallback);
        materialDialogBuilder = materialDialogBuilder.customView(R.layout.dialog_datepicker, false)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        int year = datePicker.getYear();
                        int month = datePicker.getMonth()+1;
                        int dayOfMonth = datePicker.getDayOfMonth();
                        String givenDateString = String.format(Locale.US, "%02d-%02d-%d", month, dayOfMonth, year);
                        System.out.println("Date = "+ givenDateString);
                        dialogCallback.onDialogCallback(DialogResponse.POSITIVE, new String[]{givenDateString});

                    }
                });
        MaterialDialog materialDialog = materialDialogBuilder.build();
        datePicker = (DatePicker) materialDialog.findViewById(R.id.datePicker);
        return materialDialog;
    }

    private MaterialDialog.Builder setDefault(Context context, String title, String content, String[] buttonText, Drawable icon, final DialogCallback dialogCallback) {
        MaterialDialog.Builder materialDialogBuilder = new MaterialDialog.Builder(context).canceledOnTouchOutside(false);
        if (title != null)
            materialDialogBuilder = materialDialogBuilder.title(title);
        if (content != null)
            materialDialogBuilder = materialDialogBuilder.content(content);
        if (buttonText!=null && buttonText.length>BUTTON_POSITIVE && buttonText[BUTTON_POSITIVE] != null) {
            materialDialogBuilder = materialDialogBuilder.positiveText(buttonText[BUTTON_POSITIVE]);
            materialDialogBuilder = materialDialogBuilder.onPositive(new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    if (dialogCallback != null)
                        dialogCallback.onDialogCallback(DialogResponse.POSITIVE, null);
                }
            });
        }
        if (buttonText!=null && buttonText.length>BUTTON_NEGATIVE && buttonText[BUTTON_NEGATIVE] != null) {
            materialDialogBuilder = materialDialogBuilder.negativeText(buttonText[BUTTON_NEGATIVE]);
            materialDialogBuilder = materialDialogBuilder.onNegative(new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    if (dialogCallback != null)
                        dialogCallback.onDialogCallback(DialogResponse.NEGATIVE, null);
                }
            });
        }
        if (buttonText!=null && buttonText.length>BUTTON_NEUTRAL && buttonText[BUTTON_NEUTRAL] != null) {
            materialDialogBuilder = materialDialogBuilder.neutralText(buttonText[BUTTON_NEUTRAL]);
            materialDialogBuilder = materialDialogBuilder.onNeutral(new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    if (dialogCallback != null)
                        dialogCallback.onDialogCallback(DialogResponse.NEUTRAL, null);
                }
            });
        }
        if (icon != null)
            materialDialogBuilder = materialDialogBuilder.icon(icon);
        return materialDialogBuilder;
    }

    public enum DialogResponse {
        POSITIVE("POSITIVE"),
        NEGATIVE("NEGATIVE"),
        NEUTRAL("NEUTRAL");

        private String stringValue;

        DialogResponse(String toString) {
            stringValue = toString;
        }

        @Override
        public String toString() {
            return stringValue;
        }
    }

}
