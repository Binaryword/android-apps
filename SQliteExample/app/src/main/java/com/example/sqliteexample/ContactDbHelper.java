package com.example.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1 ;

    public static  final String CREATE_TABLE = "create table " + ContactContract.ContactSchemma.TABLE_NAME + " ( " +
        ContactContract.ContactSchemma.CONTACT_ID + " number, "+ ContactContract.ContactSchemma.CONTACT_NAME + " text, " +
            ContactContract.ContactSchemma.CONTACT_MAIL + " text ); " ;

    public static final String DELETE_TABLE = "drop table if exists " +  ContactContract.ContactSchemma.TABLE_NAME ;

    public ContactDbHelper(Context context){

        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

      sqLiteDatabase.execSQL(CREATE_TABLE);
      Log.d("Database Operation" , "Database Created")  ;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(DELETE_TABLE);
        Log.d("Database Operation" , "Database Deleted")  ;
        onCreate(sqLiteDatabase);
    }

    // helper method to add Contact to db ..
    public void addContact(int id , String name , String email , SQLiteDatabase database){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactSchemma.CONTACT_ID , id);
        contentValues.put(ContactContract.ContactSchemma.CONTACT_NAME , name);
        contentValues.put(ContactContract.ContactSchemma.CONTACT_MAIL, email);

        database.insert(ContactContract.ContactSchemma.TABLE_NAME,null, contentValues);
        Log.d("Database Operation" , "One Row Inserted");
    }

    // helper method to read contact
    public Cursor readContact(SQLiteDatabase sqLiteDatabase){

        String colums[] = {ContactContract.ContactSchemma.CONTACT_ID , ContactContract.ContactSchemma.CONTACT_NAME ,
                ContactContract.ContactSchemma.CONTACT_MAIL} ;

        Cursor cursor = sqLiteDatabase.query(ContactContract.ContactSchemma.TABLE_NAME , colums , null , null , null,null , null);
        return cursor ;
    }


    // helper method to update contact
    public void updateContac(int id , String name , String email , SQLiteDatabase database){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactSchemma.CONTACT_NAME , name);
        contentValues.put(ContactContract.ContactSchemma.CONTACT_MAIL ,  email);

        String condition = ContactContract.ContactSchemma.CONTACT_ID +" =" + id ;

        database.update(ContactContract.ContactSchemma.TABLE_NAME , contentValues, condition , null);
        Log.d("Database Operation" , "Database Updated");

    }// end of method

    // helper method to delete method
    public void deleteContact(int id , SQLiteDatabase database) {

        String condition = ContactContract.ContactSchemma.CONTACT_ID + " =" + id ;
        database.delete(ContactContract.ContactSchemma.TABLE_NAME, condition , null);
        Log.d("Database Operation" , "Database Deleted");

    }// end of method..
}
