package com.example.sharedprefdemo;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrenceSetting {

    SharedPreferences mSharedPreferences ;
    Context mContext ;

    public SharedPrefrenceSetting(Context context){

        this.mContext = context ;
        mSharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.shared_pref_file) , Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status){

        SharedPreferences.Editor editor = mSharedPreferences.edit() ;
        editor.putBoolean(mContext.getResources().getString(R.string.login_status) , status).commit();
    }

    public boolean readLoginStatus(){
        boolean status = false ;
        status = mSharedPreferences.getBoolean(mContext.getResources().getString(R.string.login_status) , false);
        return  status;
     }
}
