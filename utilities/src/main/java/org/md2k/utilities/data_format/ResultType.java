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
 * Wrapper class for <code>ActivityType</code>.
 */
public class ResultType {
    /**
     * Nested class for Activity type constants.
     * <p>
     *     Available constants are:
     *  <ul>
     *      <li><code>STILL</code> - Integer value = 0.</li>
     *      <li><code>ON_FOOT</code> - Integer value = 1.</li>
     *      <li><code>TILTING</code> - Integer value = 2.</li>
     *      <li><code>WALKING</code> - Integer value = 3.</li>
     *      <li><code>RUNNING</code> - Integer value = 4.</li>
     *      <li><code>ON_BICYCLE</code> - Integer value = 5.</li>
     *      <li><code>IN_VEHICLE</code> - Integer value = 6.</li>
     *      <li><code>UNKNOWN</code> - Integer value = 7.</li>
     *  </ul>
     * </p>
     */
    public class ActivityType{
        public static final int STILL = 0;
        public static final int ON_FOOT = 1;
        public static final int TILTING = 2;
        public static final int WALKING = 3;
        public static final int RUNNING = 4;
        public static final int ON_BICYCLE = 5;
        public static final int IN_VEHICLE = 6;
        public static final int UNKNOWN = 7;
        int value;

        /**
         * Constructor
         * @param value Integer value for the desired activity type.
         */
        ActivityType(int value){
            this.value = value;
        }
    }
}