package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button ;
    TextView screen ;
    TextView adScreen ;
    Calculate mCalculate = new Calculate();;
    private static String SHOW_MESSAGE = "message" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        screen = findViewById(R.id.id_text_screen) ;
        adScreen = findViewById(R.id.id_adScreen) ;
        screen.setText("0");
        adScreen.setText("");

    }

    public void activateOperand(View view) {

        if( screen.getText().toString().equals("0") || screen.getText().toString().equals("00")){
            screen.setText("");
            Log.d(SHOW_MESSAGE , "only zero in the screen") ;
        }

        Log.d(SHOW_MESSAGE , "loop") ;

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

            default:


        }

        if(screen.getText().toString().equals("."))
            screen.setText("0.");

        Log.d( SHOW_MESSAGE , screen.getText().toString() ) ;

    }

    public void activateOperation(View view) {

            if( screen.getText().toString().equals(null) || screen.getText().toString().equals("0")
            || screen.getText().toString().equals("0.") )
                return ;


            Double fn = Double.parseDouble(screen.getText().toString().trim());
            mCalculate.setFirstNum(fn);

            //String screen_operation =


        // checking which operation was clicked
        switch (view.getId()){
            case R.id.id_button_add :
                mCalculate.setOperator("+");
                Log.d(SHOW_MESSAGE , "addition operation");
                break;
            case R.id.id_button_subtract :
                mCalculate.setOperator("-");
                Log.d(SHOW_MESSAGE , "subtraction operation");
                break;
            case R.id.id_button_multiply :
                mCalculate.setOperator("*");
                Log.d(SHOW_MESSAGE , "multiplication operation");
                break;
            case R.id.id_button_divide :
                mCalculate.setOperator("/");
                Log.d(SHOW_MESSAGE , "divide operation");
                break;
            case R.id.id_button_assignment :
                Log.d(SHOW_MESSAGE , "assignment operation");
                Log.d(SHOW_MESSAGE , "operator is : =>" + mCalculate.getOperator());
                break;
            case R.id.id_button_sqr :
                mCalculate.compute(fn , 0 , "sqr");
                default:
                    mCalculate.setOperator("");

        }

      //  String text = String.format("%f %s" , mCalculate.getFirstNum() , mCalculate.getOprator());
        adScreen.setText(mCalculate.getFirstNum() + " " + mCalculate.getOperator());
        screen.setText("0");
        Log.d(SHOW_MESSAGE , "operation sertisfied");
    }

    // equal sign helper method
    public void performCompuation(View view){

        if(mCalculate.getOperator().equals("") || mCalculate.getOperator().equals(null))
            return;

        Log.d(SHOW_MESSAGE , "screen data :" + screen.getText().toString());
        if(screen.getText().toString().equals("0."))
            return ;

        Double fn = mCalculate.getFirstNum() ;
        String operator = mCalculate.getOperator() ;

        Double sn = Double.parseDouble(screen.getText().toString().trim()) ;
        Log.d(SHOW_MESSAGE , "opeartion display :" + fn + " " + operator + " " + sn);
        Double result = mCalculate.compute(fn , sn , operator);

        Log.d(SHOW_MESSAGE , String.valueOf(result));
        screen.setText(String.valueOf(result));
        clearCache();

    }


    public void clearCache(){
        mCalculate.setOperator("");
        adScreen.setText("");
        mCalculate.setFirstNum(0);
        mCalculate.setSecondNum(0);
    }

    public void activateModification(View view) {


        switch(view.getId())
        {
            case R.id.id_button_clrall :
                screen.setText("0");
                break ;
            case R.id.id_button_clr :

                break ;
        }

    }

}
