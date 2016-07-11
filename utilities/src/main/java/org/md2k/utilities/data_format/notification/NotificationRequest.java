package org.md2k.utilities.data_format.notification;

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
    NotificationRequest response_action;

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

    public NotificationRequest getResponse_action() {
        return response_action;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public void setResponse_option(NotificationResponseOption response_option) {
        this.response_option = response_option;
    }

    public void setResponse_action(NotificationRequest response_action) {
        this.response_action = response_action;
    }
}
