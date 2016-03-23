package com.example.skulitom.firstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawRects extends View {
    Paint paint = new Paint();

    public DrawRects(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);
        canvas.drawRect(
                getLeft()+(getRight()-getLeft())/3,
                getTop()+(getBottom()-getTop())/3,
                getRight()-(getRight()-getLeft())/3,
                getBottom()-(getBottom()-getTop())/3,paint);
        paint.setStrokeWidth(0);
        paint.setColor(Color.CYAN);
        canvas.drawRect(
                getLeft()+(getRight()-getLeft())/3,
                getTop()+(getBottom()-getTop())/3,
                getRight()-(getRight()-getLeft())/3,
                getBottom()-(getBottom()-getTop())/3,paint);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(
                getLeft()+(getRight()-getLeft())/3,
                getTop()+(getBottom()-getTop())/3,
                getRight()-(getRight()-getLeft())/3,
                getBottom()-(getBottom()-getTop())/3,paint);

    }

}
