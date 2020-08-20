package com.example.sqliteexample;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sqliteexample.R;

public class UpdateFragement extends Fragment{

    TextView  idText , nameText , emailText ;
    Button updateButton ;
    public UpdateFragement(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_update_fragement , container ,false);

        idText = view.findViewById(R.id.update_enterID_text_id);
        nameText = view.findViewById(R.id.update_enterNAME_text_id);
        emailText = view.findViewById(R.id.update_enterEmail_id);
        updateButton = view.findViewById(R.id.update_button_updateContact_id);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(idText.getText().toString());
                String name = nameText.getText().toString() ;
                String email = emailText.getText().toString() ;

                SQLiteDatabase sqLiteDatabase = MainActivity.sContactDbHelper.getWritableDatabase() ;
                MainActivity.sContactDbHelper.updateContac(id , name , email , sqLiteDatabase);
                Toast.makeText(getActivity() , "Update Successfully" , Toast.LENGTH_SHORT).show();

            }
        });


        return view ;
    }
}