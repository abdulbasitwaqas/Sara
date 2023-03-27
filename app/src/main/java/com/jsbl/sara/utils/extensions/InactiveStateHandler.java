package com.jsbl.sara.utils.extensions;

import android.os.Handler;

public class InactiveStateHandler {
    InactiveListener listener;
    boolean isPagingComplete = false;
    private long DISCONNECT_TIMEOUT;

    public InactiveStateHandler(String timeInMinutes, InactiveListener listener) {
        this.listener = listener;
        DISCONNECT_TIMEOUT = 1000 * 600 * Long.parseLong(IsTimeValid(timeInMinutes));
    }

    private String IsTimeValid(String timeInMinutes) {
        String time;
        if (timeInMinutes == null) {
            time = "30";
        } else if (timeInMinutes.equals("0")) {
            time = "30";
        } else {
            time = timeInMinutes;
        }
        return time;

    }

    public void setPagingComplete(boolean pagingComplete) {
        isPagingComplete = pagingComplete;
    }

    private Handler inactiveHandler = new Handler();

    private Runnable inactiveCallback = new Runnable() {
        @Override
        public void run() {
            if (listener != null) {
                listener.onUserInactive();
            }
        }
    };

    public void resetDisconnectTimer() {
        if (inactiveHandler != null && isPagingComplete) {
            inactiveHandler.removeCallbacks(inactiveCallback);
            inactiveHandler.postDelayed(inactiveCallback, DISCONNECT_TIMEOUT);
        }

    }

    public void stopDisconnectTimer() {
        if (inactiveHandler != null) {
            inactiveHandler.removeCallbacks(inactiveCallback);
        }
    }

    public interface InactiveListener {
        void onUserInactive();
    }
}
