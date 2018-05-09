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
 * Provides methods for constructing a notification response.
 */
public class NotificationResponse {
    public static final String OK="OK";
    public static final String CANCEL="CANCEL";
    public static final String DELAY = "DELAY";
    public static final String TIMEOUT="TIMEOUT";
    public static final String DELAY_CANCEL="DELAY_CANCEL";
    private NotificationRequest notificationRequest;
    private String status;

    /**
     * Returns the <code>NotificationRequest</code> for this <code>NotificationResponse</code>.
     * @return The <code>NotificationRequest</code> for this <code>NotificationResponse</code>.
     */
    public NotificationRequest getNotificationRequest() {
        return notificationRequest;
    }

    /**
     * Returns the status.
     * @return The status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the <code>NotificationRequest</code> for this <code>NotificationResponse</code>.
     * @param notificationRequest The <code>NotificationRequest</code> for this <code>NotificationResponse</code>.
     */
    public void setNotificationRequest(NotificationRequest notificationRequest) {
        this.notificationRequest = notificationRequest;
    }

    /**
     * Sets the notification status.
     * @param status The new notification status.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
