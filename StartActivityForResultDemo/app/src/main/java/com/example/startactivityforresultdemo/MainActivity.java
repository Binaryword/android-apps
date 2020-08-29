package com.example.startactivityforresultdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int message_request = 01;
    TextView mTextView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.display_message_id);
        Intent intent = new Intent(this, MessageActivity.class);
        startActivityForResult(intent, message_request);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == message_request){

            if(requestCode == RESULT_OK){

                    String message = data.getStringExtra("message");
                    mTextView.setText(message);

            }// IF
        }// IF

    }
}
