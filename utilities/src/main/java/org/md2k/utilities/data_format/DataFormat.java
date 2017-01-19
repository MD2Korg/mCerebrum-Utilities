package org.md2k.utilities.data_format;
/*
 * Copyright (c) 2016, The University of Memphis, MD2K Center
 * - Syed Monowar Hossain <monowar.hossain@gmail.com>
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

public class DataFormat{
    public static final int Pressure=0;
    public static final int AmbientLight=0;
    public static final int AmbientTemperature =0;
    public static final int Proximity=0;

    public class Accelerometer{
        public static final int X=0;
        public static final int Y=1;
        public static final int Z=2;
    }
    public class Gyroscope{
        public static final int X=0;
        public static final int Y=1;
        public static final int Z=2;
    }
    public class Compass{
        public static final int X=0;
        public static final int Y=1;
        public static final int Z=2;
    }
    public class ActivityType{
        public static final int Type =0;
        public static final int Confidence =1;
    }

    public class Battery {
        public static final int Parcentage=0;
        public static final int Voltage=1;
        public static final int Temperature=2;
    }

    public class Location {
        public static final int Latitude=0;
        public static final int Longitude=1;
        public static final int Altitude=2;
        public static final int Speed=3;
        public static final int Bearing=4;
        public static final int Accuracy=5;
    }
}
