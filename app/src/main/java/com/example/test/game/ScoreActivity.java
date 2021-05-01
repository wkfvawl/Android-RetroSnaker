package com.example.test.game;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.test.helper.SnakeDBOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        SnakeDBOpenHelper openHelper = new SnakeDBOpenHelper(ScoreActivity.this,"table_score",null,1);
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from table_score order by score desc limit 10",null);
        if(cursor == null){
            return;
        }
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            HashMap<String,String> map = new HashMap<>();
            map.put("rank", Integer.toString(i + 1));
            map.put("name",cursor.getString(1));
            map.put("score",cursor.getString(2));
            list.add(map);
            cursor.moveToNext();
        }
        SimpleAdapter adapter = new SimpleAdapter(ScoreActivity.this,list,R.layout.listitemlayout,
                new String[]{"rank","name","score"},
                new int[]{R.id.textView_itemrank,R.id.textView_itemname,R.id.textView_itemscore});
        ListView listView = (ListView)this.findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
