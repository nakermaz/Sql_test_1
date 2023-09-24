package com.example.projectsqlite.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyDbManager {
    private Context context;
    private MyDbHelper myDbHelper;
    private SQLiteDatabase db;

    public MyDbManager(Context context) {
        this.context = context;
        myDbHelper = new MyDbHelper(context);
    }

    public void OpenDb(){
        db = myDbHelper.getWritableDatabase();
    }

    public void insertToDb(String title, String disc){
        ContentValues cv = new ContentValues();
        cv.put(MyConstants.COLUMN_NAME_TITLE, title);
        cv.put(MyConstants.COLUMN_NAME_SUBTITLE, disc);
        db.insert(MyConstants.TABLE_NAME, null, cv);
    }

    public List<String> getFromDb(){
        List<String> tempList = new ArrayList<>();
        Cursor cursor = db.query(MyConstants.TABLE_NAME, null, null,
                null, null, null, null);

        while (cursor.moveToNext()){
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(MyConstants.COLUMN_NAME_TITLE));
            tempList.add(title);
        }
        cursor.close();
        return tempList;
    }

    public void closeDb(){
        myDbHelper.close();
    }
}
