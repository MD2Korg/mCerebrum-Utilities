package org.md2k.utilities.data_format;


/**
 * Created by monowar on 7/18/16.
 */
public class StudyInfo {
    private String id;
    private String name;
    private String version;
    private String filename;

    public StudyInfo(String id, String name, String version, String filename) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.filename = filename;
    }

    public StudyInfo() {
        id = "";
        name = "";
        version = "";
        filename = "";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getFilename() {
        return filename;
    }

    public boolean equals(StudyInfo studyInfo) {
        if (!id.equals(studyInfo.id)) return false;
        if (!name.equals(studyInfo.name)) return false;
        if (!version.equals(studyInfo.version)) return false;
        if (!filename.equals(studyInfo.filename)) return false;
        return true;
    }
}
