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

import java.util.HashMap;

/**
 * Defines a data collection event.
 */
public class Event {
    /** Type of event. */
    String type;

    /** Event identifier. */
    String id;

    /** Message for the event. */
    String message;

    /** HashMap of event parameters. */
    HashMap<String, String> parameters;

    /**
     * Constructor
     *
     * @param type Event type.
     * @param id Event identifier.
     * @param message Event message.
     */
    public Event(String type, String id, String message) {
        this.type = type;
        this.id = id;
        this.message = message;
        parameters = new HashMap<>();
    }

    /**
     * Adds a parameter to the hashMap.
     *
     * @param key Key for the parameter.
     * @param value Value of the parameter.
     */
    public void addParameters(String key, String value){
        parameters.put(key, value);
    }

    /**
     * Returns the event type.
     * @return The event type.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the event identifier.
     * @return The event identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the event message.
     * @return The event message.
     */
    public String getMessage() {
        return message;
    }
}