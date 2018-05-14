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

import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Manages the process of creating and storing <code>logfiles</code>
 */
public class LogStorage {
    private static final String logDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/logs/";
    private static String logfile;
    private static Process process;

    /**
     * Creates a <code>logfile</code> and <code>logcat</code> process for the given application.
     * @param applicationName Name of application
     */
    public static void startLogFileStorageProcess(String applicationName) {
        logfile = logDir + applicationName + ".log";

        if (logfile != null) {
            File log = new File(logDir);
            if (!log.exists()) {
                log.mkdirs();
            }
            try {
                if (process != null) {
                    process.destroy();
                }
                ProcessBuilder pb = new ProcessBuilder("logcat", "-c");
                process = pb.start();

                //Log WARNING and ERROR messages to file for offline debugging support
                pb = new ProcessBuilder("logcat", "-v", "time", "-n", "10", "-r", "1024", "-f", logfile, "*:W");
                pb.redirectErrorStream(true);

                process = pb.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
