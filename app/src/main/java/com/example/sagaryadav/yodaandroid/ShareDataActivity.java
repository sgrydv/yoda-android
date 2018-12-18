package com.example.sagaryadav.yodaandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import static android.content.Intent.ACTION_SEND;

public class ShareDataActivity extends AppCompatActivity {

    String sharedData;

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_data);

        if (ACTION_SEND.equals(getIntent().getAction())) {
            sharedData = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        }

        tvData = findViewById(R.id.tvData);
        if (sharedData != null && !TextUtils.isEmpty(sharedData)) {
            tvData.setText(sharedData);
        }
    }

}
