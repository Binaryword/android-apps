package com.example.messagesender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {

        EditText editText = findViewById(R.id.messege_box);
        String message = editText.getText().toString();
        Intent sendMessageIntent = new Intent(this, DisplayMessage.class);
        sendMessageIntent.putExtra("MESSAGE_KEY" , message);
        startActivity(sendMessageIntent);
    }
}
