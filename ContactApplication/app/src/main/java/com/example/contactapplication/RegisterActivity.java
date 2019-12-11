package com.example.contactapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText txtGmail , txtName , txtPassword ;
    Button regButton  ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtGmail = findViewById(R.id.id_regGmailtext) ;
        txtName = findViewById(R.id.regUsertext);
        txtPassword = findViewById(R.id.regPassword);
        regButton = findViewById(R.id.id_regSubmitButton);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gmail = txtGmail.getText().toString() ;
                String name = txtName.getText().toString() ;
                String password = txtPassword.getText().toString() ;

                if(gmail.equals("") || name.equals("") || password.equals("")){

                    Toast.makeText(getApplicationContext() , "form not complete" , Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(getApplicationContext() , "submit Successfull" , Toast.LENGTH_SHORT).show();
                    txtGmail.setText("");
                    txtName.setText("");
                    txtPassword.setText("");

                }// end of else...

            }

        });// end of listener

    }

}
