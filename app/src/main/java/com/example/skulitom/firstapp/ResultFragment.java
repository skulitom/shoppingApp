package com.example.skulitom.firstapp;

import android.content.Context;
import android.graphics.Bitmap;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import back.end.Currency;
import back.end.MyDBHandler;
import back.end.NumberToWord;
import back.end.PriceColor;
import back.end.itemList;


public class ResultFragment extends Fragment {

    private MyDBHandler dbHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container,false);
        ScrollView scroll = (ScrollView) view.findViewById(R.id.scrollViewResult);
        RelativeLayout linearLayout = (RelativeLayout)view.findViewById(R.id.RelativeLayoutScrollResult);

        Currency currency = new Currency();
        currency.setCurrency(((MainActivity)getActivity()).getLang());

        //linearLayout.addView(drawRects);
        Rectangle rect = new Rectangle(getActivity());
        ImageView imageView = (ImageView)view.findViewById(R.id.imageViewResult);
        Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        imageView.setImageBitmap(b);
        linearLayout.setWillNotDraw(false);


        TextView total = (TextView) view.findViewById(R.id.totalView);
        dbHandler = new MyDBHandler(getActivity(),null,null,1);
        ////- retrieve all items
        int i = 0;
        double holdTotal = 0;
        itemList dbItemList = dbHandler.databaseGetList();
        while(i<dbItemList.getItemListLength()){
            holdTotal += dbItemList.getItem(i).getTotalPrice();
            i++;
        }
        ////
        ////- numberToWord conversion
        String pounds, pennies;
        NumberToWord numConverter = new NumberToWord();
        pounds = numConverter.convert((int)Math.floor(holdTotal));
        pennies = numConverter.convert((int)Math.round(((holdTotal - Math.floor(holdTotal)) * 100)));
        ////

        ////- adding color
        PriceColor priceColor = new PriceColor();
        total.setTextColor(Color.rgb(priceColor.getRed(holdTotal),priceColor.getGreen(holdTotal),0));
        ////
        // set result text to specified currency
        total.setText(pounds.substring(0,1).toUpperCase()+pounds.substring(1) + " "+ currency.getBigCurrency()+" and " + pennies+" "+currency.getSmallCurrency()+" .");

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
            paint.setStyle(Paint.Style.FILL);
     //       paint.setAntiAlias(true);
            Rect rect = new Rect(50,50,canvas.getWidth(), 50);
            canvas.drawRect(rect, paint );
        }
    }
}
