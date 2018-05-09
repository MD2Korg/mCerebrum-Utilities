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

package org.md2k.utilities.data_format.privacy;

import java.util.ArrayList;

/**
 * Defines a privacy profile including <code>Duration</code>, a list of <code>PrivacyTypes</code>,
 * a <code>startTimestamp</code>, and a <code>status</code>.
 */
public class PrivacyData {
    Duration duration;
    ArrayList<PrivacyType> privacyTypes;
    long startTimeStamp;
    boolean status;

    /**
     * Returns the duration.
     * @return The duration.
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets the duration.
     * @param duration The duration of the privacy.
     */
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    /**
     * Returns an arraylist of privacy types.
     * @return An arraylist of privacy types.
     */
    public ArrayList<PrivacyType> getPrivacyTypes() {
        return privacyTypes;
    }

    /**
     * Sets an arraylist of privacy types.
     * @param privacyTypes An arraylist of privacy types.
     */
    public void setPrivacyTypes(ArrayList<PrivacyType> privacyTypes) {
        this.privacyTypes = privacyTypes;
    }

    /**
     * Returns the starting timestamp for the privacy event.
     * @return The starting timestamp for the privacy event.
     */
    public long getStartTimeStamp() {
        return startTimeStamp;
    }

    /**
     * Sets the starting timestamp for the privacy event.
     * @param startTimeStamp The starting timestamp for the privacy event.
     */
    public void setStartTimeStamp(long startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    /**
     * Returns the status.
     * @return The status.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the status.
     * @param status The status.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
