package org.md2k.utilities.data_format.notification;

/**
 * Created by monowar on 3/10/16.
 */
public class NotificationResponse {
    public static final String OK="OK";
    public static final String CANCEL="CANCEL";
    public static final String DELAY = "DELAY";
    public static final String TIMEOUT="TIMEOUT";
    public static final String DELAY_CANCEL="DELAY_CANCEL";
    NotificationRequest notificationRequest;
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
}
