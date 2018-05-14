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

package org.md2k.utilities.info;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.util.List;

/**
 * Provides methods for getting installation, execution, and icon information about a package.
 */
public class PackageInfo {

    /**
     * Returns the name of the package in the given context.
     * @param context Android context
     * @return The name of the package in the given context.
     */
    public static String getPackageName(Context context){
        return context.getApplicationContext().getPackageName();
    }

    /**
     * Returns whether the given package is installed or not.
     * @param context Android context
     * @param packageName Name of the package
     * @return Whether the given package is installed or not.
     */
    public static boolean isInstalled(Context context, String packageName) {
        PackageManager pm = context.getApplicationContext().getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /**
     * Wrapper method for <code>isForeground()</code>
     * @param context Android context
     * @return Whether the given app is running in the foreground.
     */
    public static boolean isForeground(Context context) {
        return isForeground(context, getPackageName(context));
    }

    /**
     * Returns whether the given app is running in the foreground.
     * @param context Android context
     * @param packageName Name of the package
     * @return Whether the given app is running in the foreground.
     */
    public static boolean isForeground(Context context, String packageName) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null)
            return false;
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
                    && appProcess.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the version code for the given package.
     * @param context Android context
     * @param packageName Name of the package
     * @return The version code for the given package.
     */
    public static int getVersionCode(Context context,String packageName){
        PackageManager pm = context.getApplicationContext().getPackageManager();
        try {
            android.content.pm.PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi.versionCode;
        } catch (PackageManager.NameNotFoundException ignored) {}
        return 0;
    }

    /**
     * Wrapper method for <code>getVersionCode()</code>.
     * @param context Android context
     * @return The version code for the given package.
     */
    public static int getVersionCode(Context context){
        return getVersionCode(context, getPackageName(context));
    }

    /**
     * Returns the version name for the given package.
     * @param context Android context
     * @param packageName Name of the package
     * @return The version name for the given package.
     */
    public static String getVersionName(Context context,String packageName){
        PackageManager pm = context.getApplicationContext().getPackageManager();
        try {
            android.content.pm.PackageInfo pi = pm.getPackageInfo(packageName, 0);
            return pi.versionName;
        } catch (PackageManager.NameNotFoundException ignored) {}
        return null;
    }

    /**
     * Wrapper method for <code>getVersionName()</code>
     * @param context Android context
     * @return The version name for the given package.
     */
    public static String getVersionName(Context context){
        return getVersionName(context, getPackageName(context));
    }

    /**
     * Returns the application name from the given context.
     * @param context Android context
     * @return The application name from the given context.
     */
    public static String getName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int stringId = applicationInfo.labelRes;
        return stringId == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(stringId);
    }

    /**
     * Returns the icon for the package.
     * @param context Android context
     * @param packageName Name of the package
     * @return The icon for the package.
     */
    public static Drawable getLauncherIcon(Context context, String packageName){
        try {
            return context.getApplicationContext().getPackageManager().getApplicationIcon(packageName);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /**
     * Wrapper method for <code>getLauncherIcon()</code>.
     * @param context Android context
     * @return The icon for the package.
     */
    public static Drawable getLauncherIcon(Context context){
        try {
            return context.getApplicationContext().getPackageManager().getApplicationIcon(getPackageName(context));
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /**
     * Returns the package description from the context.
     * @param context Android context
     * @return The package description from the context.
     */
    public static String getDescription(Context context){
        return context.getApplicationInfo().loadDescription(context.getPackageManager()).toString();
    }
}
