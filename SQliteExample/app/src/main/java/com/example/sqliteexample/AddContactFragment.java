package com.example.sqliteexample;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment {

    EditText idText, nameText , emailText ;
    Button addButton ;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        idText = view.findViewById(R.id.add_enterID_text_id);
        nameText = view.findViewById(R.id.add_enterNAME_text_id);
        emailText = view.findViewById(R.id.add_enterEmail_id);
        addButton = view.findViewById(R.id.add_button_addContact_id);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id = Integer.parseInt(idText.getText().toString());
                String name = nameText.getText().toString() ;
                String email = emailText.getText().toString() ;

                SQLiteDatabase sqLiteDatabase = MainActivity.sContactDbHelper.getWritableDatabase() ;
                MainActivity.sContactDbHelper.addContact(id , name , email , sqLiteDatabase);
                Toast.makeText(getActivity(),"Contact added" , Toast.LENGTH_SHORT).show();

            }
        });

    return view ;
    }

}
