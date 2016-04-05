package org.md2k.utilities.data_format;

import org.md2k.datakitapi.source.datasource.DataSource;
import org.md2k.datakitapi.source.platform.Platform;

/**
 * Created by monowar on 3/10/16.
 */
public class NotificationDeliver {
    public static final String DELIVERED="DELIVERED";
    public static final String INTERNAL_ERROR="INTERNAL_ERROR";
    public static final String REFUSED = "REFUSED";
    NotificationRequest notificationRequest;
    Platform platform;
    String status;

    public NotificationRequest getNotificationRequest() {
        return notificationRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setNotificationRequest(NotificationRequest notificationRequest) {
        this.notificationRequest = notificationRequest;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
