package com.example.messagesender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent() ;
        String message = intent.getStringExtra("MESSAGE_KEY");
        TextView showMessage = findViewById(R.id.display_message_id);
        showMessage.setText(message);
    }

    public void showFinal(View view) {

        startActivity(new Intent(this , FinalActivity.class));
    }
}
