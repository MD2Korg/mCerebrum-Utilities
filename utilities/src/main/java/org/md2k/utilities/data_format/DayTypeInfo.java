package org.md2k.utilities.data_format;

/**
 * Copyright (c) 2015, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
 * All rights reserved.
 * <p/>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <p/>
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * <p/>
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <p/>
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
public class DayTypeInfo {
    public static final int PRE_QUIT_INT=0;
    public static final int POST_QUIT_INT=1;
    public static final String PRE_QUIT_STRING="PRE_QUIT_DAY";
    public static final String POST_QUIT_STRING="POST_QUIT_DAY";
    public static final String PRE_QUIT_NAME="Pre Quit Day";
    public static final String POST_QUIT_NAME="Post Quit Day";
    private int day_type;
    private String day_type_string;
    private String day_type_name;

    public int getDay_type() {
        return day_type;
    }

    public String getDay_type_string() {
        return day_type_string;
    }

    public String getDay_type_name() {
        return day_type_name;
    }

    public void setDay_type(int day_type) {
        this.day_type = day_type;
        if(day_type==PRE_QUIT_INT) {
            day_type_string = PRE_QUIT_STRING;
            day_type_name=PRE_QUIT_NAME;
        }
        else if(day_type==POST_QUIT_INT) {
            day_type_string = POST_QUIT_STRING;
            day_type_name=POST_QUIT_NAME;
        }
    }

    public void setDay_type_string(String day_type_string) {
        this.day_type_string = day_type_string;
    }
    public boolean equals(DayTypeInfo dayTypeInfo){
        if(day_type!=dayTypeInfo.day_type)
            return false;
        return true;
    }
    public String log(){
        return String.valueOf(day_type)+"-"+day_type_name;
    }

    public DayTypeInfo(int day_type) {
        setDay_type(day_type);
    }
}
