package com.example.multiactivitytoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppToolBarIcon {

    Toolbar mToolbar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = findViewById(R.id.tool_bar_id);
        setSupportActionBar(mToolbar);

    }

    public void startsecondActivity(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
}
