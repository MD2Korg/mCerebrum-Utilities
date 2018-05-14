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

package org.md2k.utilities.data_format.notification;

/**
 * Provides methods for determining the response actions for the notification
 */
public class NotificationResponseAction {
    String type;
    long duration;
    String[] message;
    boolean notification;

    /**
     * Returns the notification type.
     * @return The notification type.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the duration.
     * @return The duration.
     */
    public long getDuration() {
        return duration;
    }

    /**
     * Returns the message.
     * @return the message.
     */
    public String[] getMessage() {
        return message;
    }

    /**
     * Returns the <code>notification</code> field.
     * @return The <code>notification</code> field.
     */
    public boolean isNotification() {
        return notification;
    }

    /**
     * Sets the notification type.
     * @param type The notification type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the duration.
     * @param duration The duration.
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * Sets the message.
     * @param message The message.
     */
    public void setMessage(String[] message) {
        this.message = message;
    }

    /**
     * Sets the <code>notification</code>.
     * @param notification New <code>notification</code> value.
     */
    public void setNotification(boolean notification) {
        this.notification = notification;
    }
}
