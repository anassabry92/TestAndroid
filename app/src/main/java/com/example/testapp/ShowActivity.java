package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    TextView showPhone;
    TextView showMessage;
    Intent incomingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        showPhone = findViewById(R.id.showPhone);
        showMessage = findViewById(R.id.showMessage);

        incomingIntent = getIntent();
        showPhone.setText(incomingIntent.getStringExtra(MainActivity.phone));
        showMessage.setText(incomingIntent.getStringExtra(MainActivity.message));
    }

    public void closedMethod(View view) {
        finish();
    }
}