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
 * Provides user identification information.
 */
public class UserInfo {
    String user_id;
    String uuid;

    /**
     * Constructor
     *
     * <p> Initializes <code>user_id</code> and <code>uuid</code> to null. </p>
     */
    public UserInfo() {
        user_id = null;
        uuid = null;
    }

    /**
     * Returns the user identifier.
     * @return The user identifier.
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * Sets the user identifier.
     * @param user_id The user identifier.
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * Returns the UUID.
     * @return The UUID.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the UUID.
     * @param uuid The UUID.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
