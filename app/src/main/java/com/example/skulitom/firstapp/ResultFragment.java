package com.example.skulitom.firstapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import back.end.MyDBHandler;


public class ResultFragment extends Fragment {

        MyDBHandler dbHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container,false);
        ScrollView scroll = (ScrollView) view.findViewById(R.id.scrollViewResult);
        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.LinearLayoutScrollResult);

        //linearLayout.addView(drawRects);
        Rectangle rect = new Rectangle(getActivity());
       // linearLayout.addView(rect);
        //

        TextView total = (TextView) view.findViewById(R.id.totalView);
        dbHandler = new MyDBHandler(getActivity(),null,null,1);

        int i = 1;
        double holdTotal = 0;
        while(dbHandler.checkListNull(dbHandler.getItem(i))){
            holdTotal += dbHandler.getItem(i).getTotalPrice();
            i++;
        }

        total.setText("Total : £"+holdTotal);

        return view;
    }

    private class Rectangle extends View{
        Paint paint = new Paint();

        public Rectangle(Context context) {
            super(context);
        }
        @Override
        public void onDraw(Canvas canvas) {
     //       super.onDraw(canvas);
            paint.setColor(Color.GREEN);
     //       paint.setAntiAlias(true);
            Rect rect = new Rect(20, 20,20,20);
            canvas.drawRect(rect, paint );
        }
    }
}
