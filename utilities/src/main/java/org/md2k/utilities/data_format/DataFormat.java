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
 * Provides integer constants for the data.
 */
public class DataFormat{
    /** Integer constant for Pressure. <p>Default is 0.</p> */
    public static final int Pressure = 0;

    /** Integer constant for Ambient light. <p>Default is 0.</p> */
    public static final int AmbientLight = 0;

    /** Integer constant for Ambient temperature. <p>Default is 0.</p> */
    public static final int AmbientTemperature = 0;

    /** Integer constant for Proximity. <p>Default is 0.</p> */
    public static final int Proximity = 0;

    /**
     * Nested class for Accelerometer constants.
     */
    public class Accelerometer{
        /** Integer constant for the accelerometer's x axis. <p>Default is 0.</p> */
        public static final int X = 0;
        /** Integer constant for the accelerometer's y axis. <p>Default is 1.</p> */
        public static final int Y = 1;
        /** Integer constant for the accelerometer's z axis. <p>Default is 2.</p> */
        public static final int Z = 2;
    }

    /**
     * Nested class for Gyroscope constants.
     */
    public class Gyroscope{
        /** Integer constant for the gyroscope's x axis. <p>Default is 0.</p> */
        public static final int X = 0;
        /** Integer constant for the gyroscope's y axis. <p>Default is 1.</p> */
        public static final int Y = 1;
        /** Integer constant for the gyroscope's z axis. <p>Default is 2.</p> */
        public static final int Z = 2;
    }

    /**
     * Nested class for Compass constants.
     */
    public class Compass{
        /** Integer constant for the compass' x axis. <p>Default is 0.</p> */
        public static final int X = 0;
        /** Integer constant for the compass' y axis. <p>Default is 1.</p> */
        public static final int Y = 1;
        /** Integer constant for the compass' z axis. <p>Default is 2.</p> */
        public static final int Z = 2;
    }

    /**
     * Nested class for ActivityType constants.
     */
    public class ActivityType{
        /** Integer constant for the activity Type. <p>Default is 0.</p> */
        public static final int Type = 0;
        /** Integer constant for the Confidence. <p>Default is 1.</p> */
        public static final int Confidence = 1;
    }

    /**
     * Nested class for Battery constants.
     */
    public class Battery {
        /** Integer constant for the battery Percentage. <p>Default is 0.</p> */
        // TODO: Fix spelling on percentage.
        public static final int Parcentage = 0;
        /** Integer constant for the battery Voltage. <p>Default is 1.</p> */
        public static final int Voltage = 1;
        /** Integer constant for the battery Temperature. <p>Default is 2.</p> */
        public static final int Temperature = 2;
    }

    /**
     * Nested class for Location constants.
     */
    public class Location {
        /** Integer constant for the Latitude. <p>Default is 0.</p> */
        public static final int Latitude = 0;
        /** Integer constant for the Longitude. <p>Default is 1.</p> */
        public static final int Longitude = 1;
        /** Integer constant for the Altitude. <p>Default is 2.</p> */
        public static final int Altitude = 2;
        /** Integer constant for the Speed. <p>Default is 3.</p> */
        public static final int Speed = 3;
        /** Integer constant for the Bearing. <p>Default is 4.</p> */
        public static final int Bearing = 4;
        /** Integer constant for the Accuracy. <p>Default is 5.</p> */
        public static final int Accuracy = 5;
    }
}