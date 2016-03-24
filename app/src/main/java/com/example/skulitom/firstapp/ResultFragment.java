package com.example.skulitom.firstapp;

import android.content.Context;
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

    DrawRects drawRects;
    MyDBHandler dbHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container,false);
        ScrollView scroll = (ScrollView) view.findViewById(R.id.scrollViewResult);
        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.LinearLayoutScrollResult);
        drawRects = new DrawRects(this.getActivity());
       // drawRects.setBackgroundColor(Color.DKGRAY);
       // linearLayout.addView(drawRects);
       // linearLayout.setVisibility(View.VISIBLE);

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
}
