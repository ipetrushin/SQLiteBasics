package com.example.sqlitebasics;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    DBHelper dbHelper; SQLiteDatabase db;
    ListView lv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.playlist);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();




    }
    public void displayData() { // отображаем данные на списке
        Cursor c = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_NAME, null);
        String[] table_columns = c.getColumnNames();
        int[] views = {R.id.title, R.id.artist, R.id.year};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item, c, table_columns, views, 0);
        lv.setAdapter(adapter);
    }
}