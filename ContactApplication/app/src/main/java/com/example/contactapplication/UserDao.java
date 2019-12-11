package com.example.contactapplication;


import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDao {

    @Insert
    public void addAccount(User user);
}
