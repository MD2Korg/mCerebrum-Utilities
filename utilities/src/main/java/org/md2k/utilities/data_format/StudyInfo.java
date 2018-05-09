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
 * Provides study identification information.
 */
public class StudyInfo {
    private String id;
    private String name;
    private String version;
    private String filename;

    /**
     * Constructor
     *
     * @param id Identifier.
     * @param name Name of the study.
     * @param version
     * @param filename
     */
    public StudyInfo(String id, String name, String version, String filename) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.filename = filename;
    }

    /**
     * No argument Constructor
     *
     * <p>
     *     Sets each field to an empty string.
     * </p>
     */
    public StudyInfo() {
        id = "";
        name = "";
        version = "";
        filename = "";
    }

    /**
     * Returns the identifier.
     * @return The identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the version.
     * @return The version.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Returns the filename.
     * @return The filename.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Determines if the calling <code>StudyInfo</code> object is the same as the passed <code>StudyInfo</code>.
     *
     * @param studyInfo <code>StudyInfo</code> to compare to.
     * @return Whether the objects are the same.
     */
    public boolean equals(StudyInfo studyInfo) {
        if (!id.equals(studyInfo.id))
            return false;
        if (!name.equals(studyInfo.name))
            return false;
        if (!version.equals(studyInfo.version))
            return false;
        return filename.equals(studyInfo.filename);
    }
}