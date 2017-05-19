package com.example.ruslan.cpweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Ruslan on 19.05.2017.
 */

public class MainReceiver extends BroadcastReceiver{
    public static final String STATUS_OK = "success";
    public static final String STATUS_FAIL = "failure";

    public static final String STATUS_KEY = "status";

    private MainReceiverListener mainReceiverListener;

    public void setMainReceiverListener(MainReceiverListener mainReceiverListener) {
        this.mainReceiverListener = mainReceiverListener;
    }

    public MainReceiver(MainReceiverListener mainReceiverListener) {
        this.mainReceiverListener = mainReceiverListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mainReceiverListener.onDataReceive(intent.getStringExtra(STATUS_KEY));
    }
}
