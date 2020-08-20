package com.example.sqliteexample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class ReadContactFragment extends Fragment {

    TextView mTextView ;

    public ReadContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_read_contact, container, false);

       mTextView = view.findViewById(R.id.show_contact_id) ;
       readContact();
       return view ;
    }


    public void readContact(){

          /*  this section if for
            sqlite database....*/

       /* SQLiteDatabase database = MainActivity.sContactDbHelper.getReadableDatabase();
        Cursor cursor = MainActivity.sContactDbHelper.readContact(database);

        while (cursor.moveToNext()){

            int id =  cursor.getInt(cursor.getColumnIndex(ContactContract.ContactSchemma.CONTACT_ID));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactSchemma.CONTACT_NAME));
            String mail = cursor.getString(cursor.getColumnIndex(ContactContract.ContactSchemma.CONTACT_MAIL)) ;

            StringBuilder builder = new StringBuilder();
            builder.append("\n");
            builder.append("Id : " + String.valueOf(id)).append("\n");
            builder.append("Name : " + name).append("\n");
            builder.append("Email : " + mail).append("\n\n");
            String data = mTextView.getText().toString()  +   builder.toString() ;
            mTextView.setText(data);
        }// end of while*/


         /*  this section if for
            room database....*/

       List<Contact> contactList =  MainActivity.sContactDatabase.getContactDao().readContact() ;

       for(Contact contact : contactList)
       {
           int id =  contact.getId() ;
           String name = contact.getName();
           String mail = contact.getEmail();

           StringBuilder builder = new StringBuilder();
           builder.append("\n");
           builder.append("Id : " + String.valueOf(id)).append("\n");
           builder.append("Name : " + name).append("\n");
           builder.append("Email : " + mail).append("\n\n");
           String data = mTextView.getText().toString()  +   builder.toString() ;
           mTextView.setText(data);
       }





    }

}
