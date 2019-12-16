package com.example.contactapplication;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    public void addAccount(User user);

    @Query("select * from user_entry")
    public List<User> getUsers();
}
