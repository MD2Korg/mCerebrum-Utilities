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

import org.md2k.datakitapi.source.datasource.DataSource;

/**
 * Creates a <code>NotificationRequest</code> object and provides getters and setters for it's fields.
 */
public class NotificationRequest {
    public static final String MESSAGE = "MESSAGE";
    public static final String MESSAGE_SPECIAL = "MESSAGE_SPECIAL";
    public static final String VIBRATION = "VIBRATION";
    public static final String TONE = "TONE";
    public static final String SCREEN = "SCREEN";
    public static final String NOTIFICATION = "NOTIFICATION";
    String id;
    String name;
    String type;
    int priority;
    DataSource datasource;
    String format;
    int repeat;
    long duration;
    String[] message;
    NotificationResponseOption response_option;
    NotificationRequest response_action;

    /**
     * Returns the id.
     * @return The id.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type.
     * @return The type.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the priority.
     * @return The priority.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the <code>DateSource</code>.
     * @return The <code>DateSource</code>.
     */
    public DataSource getDatasource() {
        return datasource;
    }

    /**
     * Returns the format.
     * @return The format.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Returns the repeat.
     * @return The repeat.
     */
    public int getRepeat() {
        return repeat;
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
     * @return The message.
     */
    public String[] getMessage() {
        return message;
    }

    /**
     * Returns the response option.
     * @return The response option.
     */
    public NotificationResponseOption getResponse_option() {
        return response_option;
    }

    /**
     * Returns the response action.
     * @return The response action.
     */
    public NotificationRequest getResponse_action() {
        return response_action;
    }

    /**
     * Sets the id.
     * @param id Notificiation id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the name.
     * @param name Notification name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the type.
     * @param type Notificiation type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the priority.
     * @param priority Notification priority value.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Sets the <code>DataSource</code>.
     * @param datasource Notification's <code>DataSource</code>.
     */
    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }

    /**
     * Sets the format.
     * @param format Notification format.
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Sets the repeat.
     * @param repeat Number of times to repeat the notification.
     */
    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    /**
     * Sets the duration.
     * @param duration Time to display the notification.
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    /**
     * Sets the message.
     * @param message Notification message.
     */
    public void setMessage(String[] message) {
        this.message = message;
    }

    /**
     * Sets the response option.
     * @param response_option Response options for the notification.
     */
    public void setResponse_option(NotificationResponseOption response_option) {
        this.response_option = response_option;
    }

    /**
     * Sets the response action.
     * @param response_action Response action for the notification.
     */
    public void setResponse_action(NotificationRequest response_action) {
        this.response_action = response_action;
    }
}
