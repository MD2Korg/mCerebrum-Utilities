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

package org.md2k.utilities.data_format;

import org.md2k.datakitapi.time.DateTime;

/**
 * Defines an activity marker.
 * <p>
 *     Current activity markers are:
 *     <ul>
 *         <li>Smoking</li>
 *         <li>Sleep</li>
 *         <li>Wakeup</li>
 *     </ul>
 * </p>
 */
public class Marker {
    /** Constant for smoking marker. <p>"SMOKING"</p> */
    public static final String SMOKING = "SMOKING";

    /** Constant for sleeping marker. <p>"SLEEP"</p> */
    public static final String SLEEP = "SLEEP";

    /** Constant for wakeup marker. <p>"WAKEUP"</p> */
    public static final String WAKEUP = "WAKEUP";

    /** Marker type. */
    String type;

    /** Marker timestamp. */
    long timestamp;

    /**
     * Constructor
     *
     * @param type Marker type.
     */
    public Marker(String type){
        this.type = type;
        timestamp = System.currentTimeMillis();
    }

    /**
     * Returns the marker type.
     * @return The marker type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the marker type.
     * @param type The marker type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the timestamp.
     * @return The timestamp.
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp.
     * @param timestamp The timestamp.
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}