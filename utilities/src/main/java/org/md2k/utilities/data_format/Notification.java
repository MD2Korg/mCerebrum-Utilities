package org.md2k.utilities.data_format;

import org.md2k.datakitapi.source.datasource.DataSource;

import java.util.ArrayList;

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
public class Notification {
    public class OPERATION {
        public static final int SEND = 0;
        public static final int DELIVER_SUCCESS = 1;
        public static final int DELIVER_FAIL = 2;

    }
    public class NOTIFICATION_TYPE {
        public static final int EMA = 0;
        public static final int INTERVENTION = 1;
        public static final int DATA_QUALITY = 2;
    }
    public class VIBRATION {
        public static final int NOTIFICATION_ONE_TONE = 0;
        public static final int NOTIFICATION_TWO_TONE = 1;
        public static final int NOTIFICATION_ALARM = 2;
        public static final int NOTIFICATION_TIMER = 3;
        public static final int ONE_TONE_HIGH = 4;
        public static final int TWO_TONE_HIGH = 5;
        public static final int THREE_TONE_HIGH = 6;
        public static final int RAMP_UP = 7;
        public static final int RAMP_DOWN = 8;
    }
    int operation;
    String notification_type;
    int vibration_type;
    int tone_type;
    DataSource dataSource;
    String[] message;

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public String getNotification_type() {
        return notification_type;
    }

    public void setNotification_type(String notification_type) {
        this.notification_type = notification_type;
    }

    public int getVibration_type() {
        return vibration_type;
    }

    public void setVibration_type(int vibration_type) {
        this.vibration_type = vibration_type;
    }

    public int getTone_type() {
        return tone_type;
    }

    public void setTone_type(int tone_type) {
        this.tone_type = tone_type;
    }


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }
}
