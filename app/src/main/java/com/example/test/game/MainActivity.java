package com.example.test.game;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.helper.SnakeDBOpenHelper;
import com.example.test.intface.OnSnakeDeadListener;
import com.example.test.intface.OnSnakeEatFoodListener;
import com.example.test.widget.SnakeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,OnSnakeDeadListener,OnSnakeEatFoodListener {

    Button button_start;
    Button button_pause;
    Button button_up;
    Button button_down;
    Button button_left;
    Button button_right;
    TextView textview_score;
    SnakeView snakeView;

    private int highscore = 0;
    private SnakeDBOpenHelper openHelper;
    private EditText input;//Dialog中EditText对象


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_start = (Button)this.findViewById(R.id.buttonStart);
        button_start.setOnClickListener(this);
        button_pause = (Button)this.findViewById(R.id.buttonPause);
        button_pause.setOnClickListener(this);
        button_up = (Button)this.findViewById(R.id.buttonUp);
        button_up.setOnClickListener(this);
        button_down = (Button)this.findViewById(R.id.buttonDown);
        button_down.setOnClickListener(this);
        button_left = (Button)this.findViewById(R.id.buttonLeft);
        button_left.setOnClickListener(this);
        button_right = (Button)this.findViewById(R.id.buttonRight);
        button_right.setOnClickListener(this);
        textview_score = (TextView)this.findViewById(R.id.textView_Score);
        snakeView = (SnakeView)this.findViewById(R.id.myView);
        snakeView.setmOnSnakeDeadListener(this);
        snakeView.setmOnSnakeEatListener(this);

        //查询最高分数
        openHelper = new SnakeDBOpenHelper(this,"table_score",null,1);
        SQLiteDatabase db = openHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from table_score order by score desc limit 1",null);
        if(cursor != null && cursor.getCount() >= 1){
            cursor.moveToFirst();
            highscore = cursor.getInt(2);
        }
        textview_score.setText("分数：0"+ "    最高分数：" + highscore);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonStart:
                snakeView.StartGame();
                break;
            case R.id.buttonPause:
                snakeView.PauseGame();
                break;
            case R.id.buttonUp:
                snakeView.ControlGame(SnakeView.DIR_UP);
                break;
            case R.id.buttonDown:
                snakeView.ControlGame(SnakeView.DIR_DOWN);
                break;
            case R.id.buttonLeft:
                snakeView.ControlGame(SnakeView.DIR_LEFT);
                break;
            case R.id.buttonRight:
                snakeView.ControlGame(SnakeView.DIR_RIGHT);
                break;
        }
    }

    //加载菜单


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.view_rank){
            Intent intent = new Intent(MainActivity.this,ScoreActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnSnakeDead(int foodcnt) {
        LayoutInflater inflater = LayoutInflater.from(this);
        View textEntryView = inflater.inflate(R.layout.dialoglayout,null);
        input = (EditText) textEntryView.findViewById(R.id.editText_Name);
        final int score = foodcnt - 4;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("游戏结束，请输入姓名");
        builder.setView(textEntryView);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = input.getText().toString().trim();
                SQLiteDatabase db = openHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from table_score order by score desc limit 10",null);
                if(cursor == null){
                    db.close();
                    return;
                }
                if(cursor.getCount() < 10){
                    db.execSQL("insert into table_score(name,score) values(?,?)",
                            new String[]{name,Integer.toString(score)});
                }else{
                    cursor.moveToLast();
                    String id = cursor.getString(0);
                    int oldscore = cursor.getInt(2);
                    if(score > oldscore){
                        db.execSQL("update table_score set name=?,score=? where id=?",
                                new String[]{name,Integer.toString(score),id});
                    }
                }
                db.close();
            }
        });
        builder.show();
        //Toast.makeText(this,"Game Over!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnSnakeEatFood(int foodcnt) {
        if(foodcnt > highscore){
            highscore = foodcnt;
        }
        textview_score.setText("分数：" + foodcnt + "    最高分数：" + highscore);

    }
}
