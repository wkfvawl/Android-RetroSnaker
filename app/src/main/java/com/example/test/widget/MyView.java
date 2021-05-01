package com.example.test.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.test.game.R;

/**
 * Created by Administrator on 2018/12/3.
 */

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint ptRed = new Paint();
        ptRed.setColor(Color.argb(255,255,0,0));//创建红色画笔
        canvas.drawPoint(10,10,ptRed);//绘制点
        canvas.drawRect(20,0,30,50,ptRed);//绘制矩形

        Paint ptBlue = new Paint();
        ptBlue.setAntiAlias(true);//设定抗锯齿效果
        ptBlue.setColor(Color.argb(255,0,0,255));
        canvas.drawLine(50,50,150,150,ptBlue);//绘制线条

        ptBlue.setTextSize(20);//设定字体大小
        canvas.drawText("你好",100,200,ptBlue);//绘制文本

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
        canvas.drawBitmap(bitmap,10,300,ptBlue);

    }
}
