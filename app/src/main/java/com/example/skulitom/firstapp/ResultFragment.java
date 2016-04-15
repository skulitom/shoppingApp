package com.example.skulitom.firstapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import back.end.Currency;
import back.end.MyDBHandler;
import back.end.NumberToWord;
import back.end.PriceColor;
import back.end.itemList;


public class ResultFragment extends Fragment {
    // text to speech api
    private MyDBHandler dbHandler;
    private Button sayButton;
    private TextToSpeech t1;
    private String resultText = " ";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        sayButton = (Button)view.findViewById(R.id.resultSpeakButton);
        sayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(), resultText, Toast.LENGTH_SHORT).show();
                t1.speak(resultText, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        Currency currency = new Currency();
        currency.setCurrency(((MainActivity) getActivity()).getLang());


        TextView total = (TextView) view.findViewById(R.id.totalView);
        dbHandler = new MyDBHandler(getActivity(),null,null,1);
        ////- retrieve all items
        int i = 0;
        double holdTotal = 0;
        itemList dbItemList = dbHandler.databaseGetList("Current List");
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
        resultText = pounds.substring(0,1).toUpperCase()+pounds.substring(1) + " "+ currency.getBigCurrency()+" and " + pennies+" "+currency.getSmallCurrency()+" .";
        total.setText(resultText);
        t1=new TextToSpeech(getActivity().getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        return view;
    }

}
