package com.example.sagaryadav.yodaandroid;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    Button btnClickHere;
    Button btnStart;
    TextView tvMessage;

    YodaBroadcastReceivers broadcastReceiver = new YodaBroadcastReceivers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind views
        btnClickHere = findViewById(R.id.btnClickHere);
        btnStart = findViewById(R.id.btnStart);
        tvMessage = findViewById(R.id.tvMessage);

        btnClickHere.setOnClickListener((v) -> {
            showAlertMessage(R.string.app_name);
        });

        btnStart.setOnClickListener((v) -> {
            startYodaService();
        });

        //register broadcast receiver
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(YodaBroadcastReceivers.YODA_ACTION);
        registerReceiver(broadcastReceiver,intentFilter);
    }

    private void startYodaService() {
        Intent serviceIntent = new Intent(this,YodaService.class);
        startService(serviceIntent);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }


    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    public void showAlertMessage(int stringResId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert");
        builder.setMessage("Alert Message");
        builder.create().show();
    }

}
