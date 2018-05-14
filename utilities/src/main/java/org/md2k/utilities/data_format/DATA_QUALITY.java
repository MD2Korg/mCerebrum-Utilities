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
 * Provides constants for describing the quality of the collected data.
 */
public class DATA_QUALITY {
    /** Good data quality <p>Default is 0.</p> */
    public static final int GOOD = 0;

    /** Noisy data quality <p>Default is 1.</p> */
    public static final int NOISE = 1;

    /** Bad data quality <p>Default is 2.</p> */
    public static final int BAD = 2;

    /** Data collecting band off <p>Default is 3.</p> */
    public static final int BAND_OFF = 3;

    /** Data missing <p>Default is 4.</p> */
    public static final int MISSING = 4;

    /** Data collecting band not worn <p>Default is 5.</p> */
    public static final int NOT_WORN = 5;

    /** Data collecting band loose <p>Default is 6.</p> */
    public static final int BAND_LOOSE = 6;

    /** String of all data quality grades. */
    public static final String METADATA_STR =" GOOD(0), NOISE(1), BAD(2), BAND_OFF(3), " +
            "MISSING(4), NOT_WORN(5), BAND_LOOSE(6)";
}