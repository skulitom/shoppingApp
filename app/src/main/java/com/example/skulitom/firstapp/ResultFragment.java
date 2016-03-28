package com.example.skulitom.firstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import back.end.MyDBHandler;


public class ResultFragment extends Fragment {

    DrawRects drawRects;
    MyDBHandler dbHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container,false);
        ImageView img = (ImageView) view.findViewById(R.id.drawCanvasResult);
        drawRects = new DrawRects(getActivity());

        //linearLayout.addView(drawRects);
        MyDrawable rect = new MyDrawable();
        img.setImageDrawable(rect);
        //linearLayout.addView(rect);

        TextView total = (TextView) view.findViewById(R.id.totalView);
        dbHandler = new MyDBHandler(getActivity(),null,null,1);

        int i = 1;
        double holdTotal = 0;
        while(dbHandler.checkListNull(dbHandler.getItem(i))){
            holdTotal += dbHandler.getItem(i).getTotalPrice();

            i++;
        }
        holdTotal = Math.round(holdTotal*100)/100;
        total.setText("Total : £"+holdTotal);

        return view;
    }

    private class MyDrawable extends Drawable {
        @Override
        public void draw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            canvas.drawRect(100,100,100,100,paint);
        }

        @Override
        public int getOpacity() {return 0;}

        @Override
        public void setAlpha(int alpha) {}

        @Override
        public void setColorFilter(ColorFilter cf) {}
    }
}
