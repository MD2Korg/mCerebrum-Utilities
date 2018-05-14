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

package org.md2k.utilities.storage;

/**
 * Enumeration of storage types
 * <p>
 *     <ul>
 *         <li><code>"ASSET"</code></li>
 *         <li><code>"SDCARD_APPLICATION"</code></li>
 *         <li><code>"SDCARD_INTERNAL"</code></li>
 *         <li><code>"SDCARD_EXTERNAL"</code></li>
 *         <li><code>"SDCARD_EXTERNAL_PREFERRED"</code></li>
 *     </ul>
 * </p>
 */
public enum StorageType {
    ASSET("ASSET"),
    SDCARD_APPLICATION("SDCARD_APPLICATION"),
    SDCARD_INTERNAL("SDCARD_INTERNAL"),
    SDCARD_EXTERNAL("SDCARD_EXTERNAL"),
    SDCARD_EXTERNAL_PREFERRED("SDCARD_EXTERNAL_PREFERRED");

    private String stringValue;

    /**
     * Constructor
     * @param toString Storage type as a string.
     */
    StorageType(String toString) {
        stringValue = toString;
    }

    /**
     * Returns the storage type as a string.
     * @return The storage type as a string.
     */
    @Override
    public String toString() {
        return stringValue;
    }
}