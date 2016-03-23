package com.example.skulitom.firstapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.view.ViewGroup.LayoutParams;

import back.end.*;


public class SavedListsFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_saved_lists, container,false);
        ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollViewSavedLists);
       // scrollView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        MyDBHandler dbHandler;
        dbHandler = new MyDBHandler(getActivity(),null,null,1);
        // Create a LinearLayout element
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.LinearLayoutScrollSL);
       // linearLayout.setOrientation(LinearLayout.VERTICAL);
       // linearLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        int i = 1;
        while(i<=1){

            Button button = new Button(this.getActivity());
            button.setText(dbHandler.getList(i).getName());
            linearLayout.addView(button);

            i++;

        }
        //scrollView.addView(linearLayout);
        return view;
    }
}
