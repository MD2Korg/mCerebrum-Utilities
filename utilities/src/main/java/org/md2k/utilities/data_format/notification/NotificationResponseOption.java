package org.md2k.utilities.data_format.notification;

/**
 * Created by monowar on 3/11/16.
 */
public class NotificationResponseOption {
    boolean ok;
    boolean cancel;
    boolean delay;

    public boolean isOk() {
        return ok;
    }

    public boolean isCancel() {
        return cancel;
    }

    public boolean isDelay() {
        return delay;
    }

    public void setDelay(boolean delay) {
        this.delay = delay;
    }
}
