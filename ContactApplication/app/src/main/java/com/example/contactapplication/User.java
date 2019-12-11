package com.example.contactapplication;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_entry")
public class User{


    @ColumnInfo(name = "name")
    private String mUsername ;

    @ColumnInfo(name = "password")
    private String mPassword ;

    @PrimaryKey
    @ColumnInfo(name = "mail")
    private String mMail ;

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getMail() {
        return mMail;
    }

    public void setMail(String mail) {
        mMail = mail;
    }
}
