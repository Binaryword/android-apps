package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button ;
    TextView screen ;
    TextView adScreen ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        screen = findViewById(R.id.id_text_screen) ;

    }

    public void activateOperand(View view) {

        switch(view.getId())
        {
            case R.id.id_button_one :
               screen.setText( screen.getText().toString() + "1");
                break ;
            case R.id.id_button_two :
                screen.setText( screen.getText().toString() + "2");
                break ;
            case R.id.id_button_three :
                screen.setText( screen.getText().toString() + "3");
                break ;
            case R.id.id_button_four :
                screen.setText( screen.getText().toString() + "4");
                break ;
            case R.id.id_button_five :
                screen.setText( screen.getText().toString() + "5");
                break ;
            case R.id.id_button_six :
                screen.setText( screen.getText().toString() + "6");
                break ;
            case R.id.id_seven :
                screen.setText( screen.getText().toString() + "7");
                break ;
            case R.id.id_button_eight :
                screen.setText( screen.getText().toString() + "8");
                break ;
            case R.id.id_button_nine :
                screen.setText( screen.getText().toString() + "9");
                break ;
            case R.id.id_button_zero :
                screen.setText( screen.getText().toString() + "0");
                break ;
            case R.id.id_button_two_zero :
                screen.setText( screen.getText().toString() + "00");
                break ;
            case R.id.id_button_dot :
                screen.setText( screen.getText().toString() + ".");
                break ;

        }

    }

    public void activateOperation(View view) {

        

    }



    public void activateModification(View view) {


    }

}
