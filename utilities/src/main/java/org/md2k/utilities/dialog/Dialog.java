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
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

public class Dialog {
    public static final int BUTTON_POSITIVE = 0;
    public static final int BUTTON_NEGATIVE = 1;
    public static final int BUTTON_NEUTRAL = 2;
    MaterialDialog.Builder materialDialogBuilder;

    Dialog(Context context, String title, String content, String[] buttonText, Drawable icon, final DialogCallback dialogCallback) {
        materialDialogBuilder = new MaterialDialog.Builder(context).canceledOnTouchOutside(false);
        if (title != null)
            materialDialogBuilder = materialDialogBuilder.title(title);
        if (content != null)
            materialDialogBuilder = materialDialogBuilder.content(content);
        if (buttonText[BUTTON_POSITIVE] != null) {
            materialDialogBuilder = materialDialogBuilder.positiveText(buttonText[BUTTON_POSITIVE]);
            materialDialogBuilder = materialDialogBuilder.onPositive(new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    if (dialogCallback != null)
                        dialogCallback.onDialogCallback(DialogResponse.POSITIVE, null);
                }
            });
        }
        if (buttonText[BUTTON_NEGATIVE] != null) {
            materialDialogBuilder = materialDialogBuilder.negativeText(buttonText[BUTTON_NEGATIVE]);
            materialDialogBuilder = materialDialogBuilder.onNegative(new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    if (dialogCallback != null)
                        dialogCallback.onDialogCallback(DialogResponse.NEGATIVE, null);
                }
            });
        }
        if (buttonText[BUTTON_NEUTRAL] != null) {
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
