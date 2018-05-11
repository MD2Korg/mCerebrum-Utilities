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

import android.os.Environment;

/**
 * Provides constants
 * <ul>
 *     <li><code>VERSION_CODE</code> = "version_code"</li>
 *     <li><code>VERSION_NAME</code> = "version_name"</li>
 *     <li><code>APP_NAME</code> = "app_name"</li>
 *     <li><code>APP_DESCRIPTION</code> = "app_description"</li>
 *     <li><code>APP_DEVELOPER</code> = "app_developer"</li>
 *     <li><code>URL_RELEASE</code> = "url_release"</li>
 *     <li><code>URL_SOURCECODE</code> = "url_sourcecode"</li>
 *     <li><code>DIRECTORY</code> = the path to "/mCerebrum/"</li>
 *     <li><code>CONFIG_DIRECTORY</code> = DIRECTORY + "config/"</li>
 * </ul>
 */
public class Constants {
    public static String VERSION_CODE = "version_code";
    public static String VERSION_NAME = "version_name";
    public static String APP_NAME = "app_name";
    public static String APP_DESCRIPTION = "app_description";
    public static String APP_DEVELOPER = "app_developer";
    public static String URL_RELEASE = "url_release";
    public static String URL_SOURCECODE = "url_sourcecode";
    public static String DIRECTORY = Environment.getExternalStorageDirectory().getAbsolutePath() + "/mCerebrum/";
    public static String CONFIG_DIRECTORY = DIRECTORY + "config/";
}
