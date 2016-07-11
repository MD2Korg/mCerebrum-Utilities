package org.md2k.utilities.data_format.notification;

/**
 * Created by monowar on 3/11/16.
 */
public class NotificationResponseAction {
    String type;
    long duration;
    String[] message;
    boolean notification;

    public String getType() {
        return type;
    }

    public long getDuration() {
        return duration;
    }

    public String[] getMessage() {
        return message;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }
}
