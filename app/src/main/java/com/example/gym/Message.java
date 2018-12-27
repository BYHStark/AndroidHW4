package com.example.gym;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.HashMap;

public class Message extends AppCompatActivity {

    private ListView lv;
    private BaseAdapter adapter;
    private String[] datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        lv = (ListView) findViewById(R.id.listviewsimple2);
        DBHelper dbHelper = new DBHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("training", "running");
        values.put("trainer", "coach fui");

        db.insert("train", null, values);
        db.close();

        db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT " +
                "trainer" + " FROM " + "train";
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList trainList=new ArrayList();
        if(cursor.moveToFirst()) {
            do {
                trainList.add(cursor.getString(cursor.getColumnIndex("trainer")));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        datas = new String[trainList.size()];
        for (int i = 0; i<trainList.size(); i++) {
            datas[i] = String.valueOf(trainList.get(i));
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, datas);
        lv.setAdapter(adapter);
    }
}
