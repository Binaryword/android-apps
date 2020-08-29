package com.example.startactivityforresultdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    Button sendMessage ;
    EditText mTextView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        sendMessage = findViewById(R.id.send_button_id);
        mTextView = findViewById(R.id.enter_message_id);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = mTextView.getText().toString() ;
                Intent intent = new Intent();
                intent.putExtra("message" , message);
                setResult(RESULT_OK , intent);
                finish();

            }
        });

    }
}
