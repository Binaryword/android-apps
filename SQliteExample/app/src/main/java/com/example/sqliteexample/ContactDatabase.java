package com.example.sqliteexample;

import androidx.room.RoomDatabase;

public abstract class ContactDatabase extends RoomDatabase {

    public abstract ContactDao getContactDao();
}
