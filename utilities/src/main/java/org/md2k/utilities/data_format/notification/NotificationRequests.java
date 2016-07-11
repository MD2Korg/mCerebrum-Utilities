package org.md2k.utilities.data_format.notification;

import java.util.ArrayList;

/**
 * Created by monowar on 3/10/16.
 */
public class NotificationRequests {
    ArrayList<NotificationRequest> notification_option;

    public NotificationRequests() {
        this.notification_option = new ArrayList<>();
    }

    public ArrayList<NotificationRequest> getNotification_option() {
        return notification_option;
    }

    public void setNotification_option(ArrayList<NotificationRequest> notification_option) {
        this.notification_option = notification_option;
    }
}
