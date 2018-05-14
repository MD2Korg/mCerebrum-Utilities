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

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.squareup.leakcanary.LeakCanary;

/**
 * Provides methods that implement <code>LeakCanary</code> in this application.
 * More information about <code>LeakCanary</code> can be found <a href="https://github.com/square/leakcanary">here</a>.
 */
public class ApplicationWithLeakCanary extends Application {
    private static Context context;

    /**
     * Sets the context of this object as the application context and calls <code>setupLeakCanary()</code>.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationWithLeakCanary.context = getApplicationContext();
        setupLeakCanary();
    }

    /**
     * Returns the context of this object.
     * @return The context of this object.
     */
    public static Context getAppContext() {
        return ApplicationWithLeakCanary.context;
    }

    /**
     * Sets <code>LeakCanary</code> up for heap analysis.
     */
    void setupLeakCanary(){
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    /**
     * Called by the system when the device configuration changes while your component is running.
     * @param newConfig New device configuration.
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     * Called when the overall system is running low on memory.
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
