package com.example.sqlitebasics;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "tunes.db";
    final static String TABLE_NAME = "tunes";
    final static int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "(title TEXT, artist TEXT, year INT)");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (\"Hello\", \"Test\", 2000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // вызвается после смены версии
    }
}
