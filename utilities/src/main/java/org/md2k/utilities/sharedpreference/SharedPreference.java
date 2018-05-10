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

package org.md2k.utilities.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *
 */
public class SharedPreference {
    /**
     * Writes the key-value pair to <code>SharedPreferences</code>.
     * @param context Android context
     * @param key Key
     * @param value Value
     */
    public static void write(Context context, String key, boolean value){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Writes the key-value pair to <code>SharedPreferences</code>.
     * @param context Android context
     * @param key Key
     * @param value Value
     */
    public static void write(Context context, String key, int value){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * Writes the key-value pair to <code>SharedPreferences</code>.
     * @param context Android context
     * @param key Key
     * @param value Value
     */
    public static void write(Context context, String key, long value){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * Writes the key-value pair to <code>SharedPreferences</code>.
     * @param context Android context
     * @param key Key
     * @param value Value
     */
    public static void write(Context context, String key, float value){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * Writes the key-value pair to <code>SharedPreferences</code>.
     * @param context Android context
     * @param key Key
     * @param value Value
     */
    public static void write(Context context, String key, String value){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Reads the value associated with the given key-value pair from <code>SharedPreferences</code>.
     * @param context Android context
     * @param key Key
     * @param defaultValue Value
     * @return The given value from <code>SharedPreferences</code>
     */
    public static boolean readBoolean(Context context, String key, boolean defaultValue){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return sharedPref.getBoolean(key, defaultValue);
    }

    /**
     * Reads the value associated with the given key-value pair from <code>SharedPreferences</code>.
     * @param context Android context
     * @param key Key
     * @param defaultValue Value
     * @return The given value from <code>SharedPreferences</code>
     */
    public static int readInt(Context context, String key, int defaultValue){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return sharedPref.getInt(key, defaultValue);
    }

    /**
     * Reads the value associated with the given key-value pair from <code>SharedPreferences</code>.
     * @param context Android context
     * @param key Key
     * @param defaultValue Value
     * @return The given value from <code>SharedPreferences</code>
     */
    public static long readLong(Context context, String key, long defaultValue){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return sharedPref.getLong(key, defaultValue);
    }

    /**
     * Reads the value associated with the given key-value pair from <code>SharedPreferences</code>.
     * @param context Android context
     * @param key Key
     * @param defaultValue Value
     * @return The given value from <code>SharedPreferences</code>
     */
    public static float readFloat(Context context, String key, float defaultValue){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return sharedPref.getFloat(key, defaultValue);
    }

    /**
     * Reads the value associated with the given key-value pair from <code>SharedPreferences</code>.
     * @param context Android context
     * @param key Key
     * @param defaultValue Value
     * @return The given value from <code>SharedPreferences</code>
     */
    public static String readString(Context context, String key, String defaultValue){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return sharedPref.getString(key,defaultValue);
    }
}
