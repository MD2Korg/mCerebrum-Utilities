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

/**
 * Provides information about the day, whether the day is a pre quit day or a post quit day.
 */
public class DayTypeInfo {
    /** Integer constant for denoting a pre quit day. <p>Default value is 0.</p> */
    public static final int PRE_QUIT_INT = 0;

    /** Integer constant for denoting a post quit day. <p>Default value is 1.</p> */
    public static final int POST_QUIT_INT = 1;

    /** String constant for denoting a pre quit day. <p>Default value is "PRE_QUIT_DAY".</p> */
    public static final String PRE_QUIT_STRING = "PRE_QUIT_DAY";

    /** String constant for denoting a post quit day. <p>Default value is "POST_QUIT_DAY".</p> */
    public static final String POST_QUIT_STRING = "POST_QUIT_DAY";

    /** String name for denoting a pre quit day. <p>Default value is "Pre Quit Day".</p> */
    public static final String PRE_QUIT_NAME = "Pre Quit Day";

    /** String name for denoting a post quit day. <p>Default value is "Post Quit Day".</p> */
    public static final String POST_QUIT_NAME = "Post Quit Day";

    private int day_type;
    private String day_type_string;
    private String day_type_name;

    /**
     * Constructor
     *
     * @param day_type Day type (Pre or post quit).
     */
    public DayTypeInfo(int day_type) {
        setDay_type(day_type);
    }

    /**
     * Returns the integer day type.
     * @return The integer day type.
     */
    public int getDay_type() {
        return day_type;
    }

    /**
     * Sets the integer day type, <code>day_type_string</code>, and <code>day_type_name</code>.
     * @param day_type The integer day type.
     */
    public void setDay_type(int day_type) {
        this.day_type = day_type;
        if(day_type == PRE_QUIT_INT) {
            day_type_string = PRE_QUIT_STRING;
            day_type_name = PRE_QUIT_NAME;
        }
        else if(day_type == POST_QUIT_INT) {
            day_type_string = POST_QUIT_STRING;
            day_type_name = POST_QUIT_NAME;
        }
    }

    /**
     * Returns the day type string.
     * @return The day type string.
     */
    public String getDay_type_string() {
        return day_type_string;
    }

    /**
     * Sets the day type string.
     * @param day_type_string The day type string.
     */
    public void setDay_type_string(String day_type_string) {
        this.day_type_string = day_type_string;
    }

    /**
     * Returns the name day type.
     * @return The name day type.
     */
    public String getDay_type_name() {
        return day_type_name;
    }

    /**
     * Determines if the calling <code>DayTypeInfo</code> object is the same as the passed <code>DayTypeInfo</code>.
     *
     * @param dayTypeInfo <code>DayTypeInfo</code> object to compare to.
     * @return Whether the caller and the passed object are the same.
     */
    public boolean equals(DayTypeInfo dayTypeInfo){
        return day_type == dayTypeInfo.day_type;
    }

    /**
     * Generates a string for logging the day type.
     * @return A string for logging the day type.
     */
    public String log(){
        return String.valueOf(day_type) + "-" + day_type_name;
    }
}