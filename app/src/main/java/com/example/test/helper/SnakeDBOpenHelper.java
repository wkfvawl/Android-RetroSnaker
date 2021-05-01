package com.example.test.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2018/12/4.
 */

public class SnakeDBOpenHelper extends SQLiteOpenHelper {

    public SnakeDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table table_score(" +
                "id INTEGER NOT NULL PRIMARY KEY ," +
                "name TEXT,score Integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS table_score");
        onCreate(sqLiteDatabase);
    }
}
