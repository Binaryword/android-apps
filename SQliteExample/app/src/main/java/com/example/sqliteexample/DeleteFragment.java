package com.example.sqliteexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteFragment extends Fragment {


    EditText editText ;
    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        editText = view.findViewById(R.id.delete_enterId_id);
        Button button = view.findViewById(R.id.delete_deleteButton_id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(editText.getText().toString()) ;
                SQLiteDatabase sqLiteDatabase = MainActivity.sContactDbHelper.getWritableDatabase();
                MainActivity.sContactDbHelper.deleteContact(id ,sqLiteDatabase);
                Toast.makeText(getActivity() , "Delete successFull" , Toast.LENGTH_SHORT).show();
                editText.setText("");
            }
        });


        return view ;
    }




}
