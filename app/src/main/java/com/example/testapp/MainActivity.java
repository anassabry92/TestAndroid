package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnNxt;
    Intent outIntent;
    EditText editPhone;
    EditText editMessage;
    TextView errPhone;
    TextView errMsg;
    public static final String phone = "PHONE";
    public static final String message = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNxt = findViewById(R.id.btnNxt);
        editPhone = findViewById(R.id.editPhone);
        editMessage = findViewById(R.id.editMessage);
        errPhone = findViewById(R.id.phoneErr);
        errMsg = findViewById(R.id.messageErr);
        outIntent = new Intent(MainActivity.this,ShowActivity.class);

        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inPhone = editPhone.getText().toString();
                if(inPhone.equals(""))
                    errPhone.setVisibility(View.VISIBLE);
                else
                    errPhone.setVisibility(View.INVISIBLE);

                String inMessage = editMessage.getText().toString();
                if(inMessage.equals(""))
                    errMsg.setVisibility(View.VISIBLE);
                else
                    errMsg.setVisibility(View.INVISIBLE);

                outIntent.putExtra(phone,inPhone);
                outIntent.putExtra(message,inMessage);

                if (!editPhone.getText().toString().equals("") &&
                        !editMessage.getText().toString().equals("")) {
                    startActivity(outIntent);
                }
            }
        });
    }

    public void closeMethod(View view) {
        finish();
    }
}