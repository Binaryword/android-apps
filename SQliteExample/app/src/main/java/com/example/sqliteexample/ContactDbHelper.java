package com.example.sqliteexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1 ;

    public static  final String CREATE_TABLE = "create table " + ContactContract.ContactSchemma.TABLE_NAME + " ( " +
        ContactContract.ContactSchemma.CONTACT_ID + " number, "+ ContactContract.ContactSchemma.CONTACT_NAME + " text, " +
            ContactContract.ContactSchemma.CONTACT_MAIL + " text ); " ;

    public static final String DELETE_TABLE = "drop table if exist " + ContactContract.ContactSchemma.TABLE_NAME ;

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
        onCreate(sqLiteDatabase);
    }
}
