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
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.Arrays;

public class DialogSingleChoice extends Dialog {
    public DialogSingleChoice(Context context, String title, String content, String[] items, String selectedItem, Drawable icon, final DialogCallback dialogCallback) {
        super(context,title, content, new String[]{"Select","Cancel",null}, icon, dialogCallback);
        int selected=-1;
        for(int i=0;i<items.length && selectedItem!=null;i++)
            if(items[i].equals(selectedItem))
                selected=i;

        materialDialogBuilder=materialDialogBuilder.items((CharSequence[]) items)
                .itemsCallbackSingleChoice(selected, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        dialogCallback.onDialogCallback(DialogResponse.POSITIVE,new String[]{text.toString()});
                        return true;
                    }
                });
        materialDialogBuilder.show();
    }
}
