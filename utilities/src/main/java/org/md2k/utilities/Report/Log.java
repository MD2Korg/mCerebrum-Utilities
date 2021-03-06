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

package org.md2k.utilities.Report;

/**
 * Provides methods for writing log messages.
 */
public class Log {
    public static final boolean DEBUG = true;

    /**
     * Sends a <code>DEBUG</code> log message.
     * @param TAG Log message tag
     * @param logMessage Message to log
     */
    public static void d(String TAG, String logMessage){
        if(DEBUG) android.util.Log.d("[MD2K]" + TAG, logMessage);
    }

    /**
     * Sends a <code>WARN</code> log message.
     * @param TAG Log message tag
     * @param logMessage Message to log
     */
    public static void w(String TAG, String logMessage){
        android.util.Log.w("[MD2K]" + TAG, logMessage);
    }

    /**
     * Sends an <code>ERROR</code> log message.
     * @param TAG Log message tag
     * @param logMessage Message to log
     */
    public static void e(String TAG, String logMessage){
        android.util.Log.e("[MD2K]" + TAG, logMessage);
    }
}
