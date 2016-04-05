package org.md2k.utilities.data_format;

/**
 * Created by monowar on 3/11/16.
 */
public class NotificationResponseOption {
    boolean ok;
    boolean cancel;
    boolean delay;
    long delay_time;

    public boolean isOk() {
        return ok;
    }

    public boolean isCancel() {
        return cancel;
    }

    public boolean isDelay() {
        return delay;
    }

    public long getDelay_time() {
        return delay_time;
    }

    public void setDelay(boolean delay) {
        this.delay = delay;
    }

    public void setDelay_time(long delay_time) {
        this.delay_time = delay_time;
    }
}
