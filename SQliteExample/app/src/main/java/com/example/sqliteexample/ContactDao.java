package com.example.sqliteexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    public void addContact(Contact contact);

    @Query("select * from contact")
    public List<Contact> readContact();

    @Delete
    public void deleteContact();

    @Update
    public void updateContact(Contact contact);
}
