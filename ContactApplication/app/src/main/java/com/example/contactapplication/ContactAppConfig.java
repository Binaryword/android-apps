package com.example.contactapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class ContactAppConfig{

        SharedPreferences sharedPreferences ;
        Context context;

        public ContactAppConfig(Context context){
            this.context = context ;
            sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.res_pref_file_name), Context.MODE_PRIVATE);

        }


        public void writePreference(boolean status){

            SharedPreferences.Editor editor = sharedPreferences.edit() ;
            editor.putBoolean(context.getResources().getString(R.string.res_pref_file_status) , status) ;

        }

        public boolean readPreference(){

            boolean defaultStatus ;
            defaultStatus = sharedPreferences.getBoolean(context.getResources().getString(R.string.res_pref_file_status) , false) ;
            return defaultStatus ;
        }



}