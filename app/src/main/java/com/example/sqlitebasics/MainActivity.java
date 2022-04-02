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
        displayData();
    }
    // TODO: 1) реализовать добавление записей (данные вводит пользователь в текстовые поля)
    // TODO: 2) отображать общее число записей
    // TODO: 3*) сортировка по полям (по убыванию, возрастанию)

    public void displayData() { // отображаем данные на списке
        Cursor c = db.rawQuery("SELECT * FROM " + dbHelper.TABLE_NAME, null);
        /* курсор - структура данных, можно обращаться к отдельным записям и полям
        c.getCount();
        c.moveToLast();
        c.getInt(1);

         */
        String[] table_columns = c.getColumnNames();

        // добавлено поле id в таблицу, т.к. оно требуется для SimpleCursorAdapter
        int[] views = {R.id.id, R.id.title, R.id.artist, R.id.year};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item, c, table_columns, views, 0);
        lv.setAdapter(adapter);
    }
}