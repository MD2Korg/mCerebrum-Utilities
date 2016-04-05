package org.md2k.utilities.data_format;

import org.md2k.datakitapi.source.datasource.DataSource;

/**
 * Created by monowar on 3/10/16.
 */
public class NotificationRequest {
    public static final String MESSAGE="MESSAGE";
    public static final String VIBRATION="VIBRATION";
    public static final String TONE = "TONE";
    public static final String SCREEN="SCREEN";
    public static final String NOTIFICATION="NOTIFICATION";
    String id;
    String name;
    String type;
    int priority;
    DataSource datasource;
    String format;
    int repeat;
    long duration;
    String[] message;
    NotificationResponseOption response_option;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }

    public DataSource getDatasource() {
        return datasource;
    }

    public String getFormat() {
        return format;
    }

    public int getRepeat() {
        return repeat;
    }

    public long getDuration() {
        return duration;
    }

    public String[] getMessage() {
        return message;
    }

    public NotificationResponseOption getResponse_option() {
        return response_option;
    }

}
