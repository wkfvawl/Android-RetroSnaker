package com.example.test.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

import com.example.test.intface.OnSnakeDeadListener;
import com.example.test.intface.OnSnakeEatFoodListener;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Administrator on 2018/12/3.
 */

public class SnakeView extends View {

    private int mBlocksize = 20;//单元格的边长
    private int mWidth,mHeight;//游戏区域的范围,代表单元格的个数
    private int mOffsetX,mOffsetY;//活动区域的偏移量
    private int mSnakeLen;//蛇的长度
    private int[] mSnakeX = new int[100];//蛇的身体坐标
    private int[] mSnakeY = new int[100];
    private int mSnakeDir;//蛇的移动方向
    private int mFoodX,mFoodY;//食物的坐标
    private int mFoodCnt;//吃到的食物个数

    Paint ptBackground = new Paint();
    Paint ptHead = new Paint();
    Paint ptBody = new Paint();
    Paint ptFood = new Paint();
    Paint ptBorder = new Paint();

    //蛇的游动方向
    public static final int DIR_UP = 0;//向上
    public static final int DIR_RIGHT = 1;//向右
    public static final int DIR_DOWN = 2;//向下
    public static final int DIR_LEFT = 3;//向左


    //定时器相关设置
    private Timer mTimer = null;
    private TimerTask mTimerTask = null;
    private Handler mHandler = null;
    private final int SNAKE_MOVE = 1;

    private int mGameStatus;
    private final int STATUS_RUN = 1;
    private final int STATUS_DEAD = 2;
    private final int STATUS_PAUSE = 3;
    private final int STATUS_START = 0;

    private OnSnakeEatFoodListener mOnSnakeEatListener;
    private OnSnakeDeadListener mOnSnakeDeadListener;

    public void setmOnSnakeEatListener(OnSnakeEatFoodListener mOnSnakeEatListener){
        this.mOnSnakeEatListener = mOnSnakeEatListener;
    }
    public void setmOnSnakeDeadListener(OnSnakeDeadListener mOnSnakeDeadListener){
        this.mOnSnakeDeadListener = mOnSnakeDeadListener;
    }

    //代码创建控件时被调用
    public SnakeView(Context context) {
        super(context);
        InitGame();
    }
    //此构造方法在XML文件中创建控件时被调用
    public SnakeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        InitGame();
    }

    public void InitGame(){
        ptBackground.setColor(Color.argb(255,0,0,0));
        ptHead.setColor(Color.argb(255,255,0,0));
        ptBody.setColor(Color.argb(255,255,211,55));
        ptBorder.setColor(Color.argb(255,255,255,255));
        ptFood.setColor(Color.argb(255,0,11,255));
        InitSnake();

        //蛇定时器
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case SNAKE_MOVE:
                        SnakeMove();
                        break;
                    default:
                        break;
                }

            }
        };


        if(mTimer == null){
            mTimer = new Timer();
        }
        if (mTimerTask == null) {
            mTimerTask = new TimerTask(){
                @Override
                public void run() {
                    Message message = new Message();
                    message.what = SNAKE_MOVE;
                    mHandler.sendMessage(message);
                }
            };
        }

        if(mTimer != null && mTimerTask != null){
            mTimer.schedule(mTimerTask,300,300);
        }
    }

    public void SnakeMove(){
        //如果游戏不处于运动状态，不进行蛇的游动
        if(mGameStatus != STATUS_RUN){
            return;
        }
        int newheadx = 0, newheady = 0;
        //计算蛇头的位置
        switch (mSnakeDir){
            case 0:
                newheadx = mSnakeX[0];
                newheady = mSnakeY[0] - 1;
                break;
            case 1:
                newheadx = mSnakeX[0] + 1;
                newheady = mSnakeY[0];
                break;
            case 2:
                newheadx = mSnakeX[0];
                newheady = mSnakeY[0] + 1;
                break;
            case 3:
                newheadx = mSnakeX[0] - 1;
                newheady = mSnakeY[0];
                break;
        }
        //判断蛇头是否超过游戏区域，如果超过进游戏区域更改游戏状态
        if(newheadx < 0 || newheadx >= mWidth || newheady < 0 || newheady >= mHeight){
            mGameStatus = STATUS_DEAD;
            if(mOnSnakeDeadListener != null){
                mOnSnakeDeadListener.OnSnakeDead(mSnakeLen);
            }
            return;
        }
        //判断蛇是否吃到食物，如果吃到食物则将身体增加，并随即生成下一个食物
        if(newheadx == mFoodX && newheady == mFoodY){
            Random random = new Random();
            mFoodX = random.nextInt(mWidth - 1);
            mFoodY = random.nextInt(mHeight - 1);
            mSnakeLen++;
            mFoodCnt++;

            if(mOnSnakeEatListener != null){
                mOnSnakeEatListener.OnSnakeEatFood(mFoodCnt);
            }
        }
        //挪动蛇的位置
        for(int i = mSnakeLen - 1; i > 0; i--){
            mSnakeX[i] = mSnakeX[i - 1];
            mSnakeY[i] = mSnakeY[i - 1];
        }

        //设定蛇头的位置
        mSnakeX[0] = newheadx;
        mSnakeY[0] = newheady;
        //触发onDraw进行重绘
        invalidate();
    }

    public void StartGame(){
        switch (mGameStatus){
            case STATUS_DEAD:
                InitSnake();
                mGameStatus = STATUS_RUN;
                if(mOnSnakeEatListener != null){
                    mOnSnakeEatListener.OnSnakeEatFood(mFoodCnt);
                }
                break;
            case STATUS_PAUSE:
                mGameStatus = STATUS_RUN;
                break;
            case STATUS_START:
                mGameStatus = STATUS_RUN;
                break;
            default:
                break;
        }
    }

    public void PauseGame(){
        if(mGameStatus == STATUS_RUN){
            mGameStatus = STATUS_PAUSE;
        }
    }

    public void ControlGame(int dir){
        if(mGameStatus != STATUS_RUN){
            return;
        }
        switch (dir){
            case DIR_UP:
                mSnakeDir = dir;
                break;
            case DIR_RIGHT:
            case DIR_DOWN:
            case DIR_LEFT:
                mSnakeDir = dir;
                break;
            default:
                break;
        }
    }

    //蛇的初始化状态
    public void InitSnake(){
        mSnakeLen = 4;
        mSnakeX[0] = 3;
        mSnakeY[0] = 0;
        mSnakeX[1] = 2;
        mSnakeY[1] = 0;
        mSnakeX[2] = 1;
        mSnakeY[2] = 0;
        mSnakeX[3] = 0;
        mSnakeY[3] = 0;
        mFoodX = 4;
        mFoodY = 4;
        mFoodCnt = 0;
        mSnakeDir = DIR_RIGHT;
    }
    //View尺寸发生变化时的方法
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = w/mBlocksize - 1;
        mHeight = h/mBlocksize - 1;
        mOffsetX = (w - mWidth * mBlocksize)/2;
        mOffsetY = (h - mHeight * mBlocksize)/2;
    }

    //Paint 类 我们称之为 画笔，为画图的过程中，定义各种参数，比如：颜色、线条样式、图案样式等。
    //Canvas 类我们定义为画布，主要提供若干方法用于绘制各种颜色图案：点、线、路径等。
    //绘制布局内容的方法
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画游戏区域背景
        canvas.drawRect(mOffsetX,mOffsetY,(mWidth) * mBlocksize + mOffsetX,
                (mHeight) * mBlocksize + mOffsetY,ptBackground);
        //画游戏区域边框
        canvas.drawLine(mOffsetX - 1,mOffsetY - 1,mWidth * mBlocksize +mOffsetX,
                mOffsetY - 1,ptBorder);
        canvas.drawLine(mOffsetX - 1,mOffsetY - 1,mOffsetX - 1,
                mHeight * mBlocksize + mOffsetY,ptBorder);
        canvas.drawLine(mWidth * mBlocksize + mOffsetX,mOffsetY - 1,
                mWidth * mBlocksize + mOffsetX,mHeight * mBlocksize + mOffsetY,ptBorder);
        canvas.drawLine(mOffsetX - 1,mHeight * mBlocksize + mOffsetY,
                mWidth * mBlocksize + mOffsetX,mHeight * mBlocksize + mOffsetY,ptBorder);
        //画食物
        canvas.drawRect(mFoodX * mBlocksize + mOffsetX,mFoodY * mBlocksize + mOffsetY,
                (mFoodX + 1) * mBlocksize + mOffsetX,
                (mFoodY + 1) * mBlocksize + mOffsetY,ptFood);
        //画蛇
        for(int i = 0; i < mSnakeLen; i++){
            if(i == 0){
                //画蛇头
                canvas.drawRect(mSnakeX[i] * mBlocksize + mOffsetX,mSnakeY[i] * mBlocksize + mOffsetY,
                        (mSnakeX[i] + 1) * mBlocksize + mOffsetX,
                        (mSnakeY[i] + 1) * mBlocksize + mOffsetY,ptHead);
            }else{
                //画蛇身
                canvas.drawRect(mSnakeX[i] * mBlocksize + mOffsetX,mSnakeY[i] * mBlocksize + mOffsetY,
                        (mSnakeX[i] + 1) * mBlocksize + mOffsetX,
                        (mSnakeY[i] + 1) * mBlocksize + mOffsetY,ptBody);
            }
        }
    }
}
