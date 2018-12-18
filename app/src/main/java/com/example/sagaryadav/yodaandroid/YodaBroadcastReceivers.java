package com.example.sagaryadav.yodaandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class YodaBroadcastReceivers extends BroadcastReceiver {

    public static final String YODA_ACTION = "yoda.android.TEST";
    private static final String TAG = YodaBroadcastReceivers.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");

        try {
            Thread.sleep(5000);
            Intent launchIntent = new Intent(context, LaunchActivity.class);
            context.startActivity(launchIntent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
