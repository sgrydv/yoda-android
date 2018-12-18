package com.example.sagaryadav.yodaandroid;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class LaunchActivity extends AppCompatActivity {

    private static final String TAG = LaunchActivity.class.getSimpleName();
    private static final String KEY_COUNTER = "counter";

    TextView tvCounter;
    Button btnIncrement;
    Button btnNext;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(KEY_COUNTER);
            Log.d(TAG, "counter : "+counter);
        }

        //bind Views
        tvCounter = findViewById(R.id.tvCounter);
        btnIncrement = findViewById(R.id.btnIncrement);
        btnNext = findViewById(R.id.btnNext);

        //set listeners
        btnIncrement.setOnClickListener(v -> {
            counter++;
            String counterString = "Counter : "+counter;
            tvCounter.setText(counterString);
        });
        btnNext.setOnClickListener(v -> {
            navigateToMainScreen();
        });
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
        String counterText = "Counter : "+counter;
        tvCounter.setText(counterText);
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
    }

    private void navigateToMainScreen() {
        Intent mainIntent = new Intent(this,MainActivity.class);
        mainIntent.putExtra(KEY_COUNTER,counter);
        startActivity(mainIntent);
    }

   /* @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ");
        outState.putInt(KEY_COUNTER,counter);
        super.onSaveInstanceState(outState);
    }*/
}
