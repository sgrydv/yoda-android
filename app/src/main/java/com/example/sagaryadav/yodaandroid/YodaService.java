package com.example.sagaryadav.yodaandroid;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class YodaService extends IntentService {

    private static final String TAG = YodaService.class.getSimpleName();


    public YodaService() {
        this("YodaService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public YodaService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent: ");

        try {
            Thread.sleep(1000);
            sendYodaBroadcast();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /*new Thread(() -> {

        }).start();*/

    }

    private void sendYodaBroadcast() {
        Intent yodaIntent = new Intent();
        yodaIntent.setAction(YodaBroadcastReceivers.YODA_ACTION);
        sendBroadcast(yodaIntent);
    }
}
