package com.example.skulitom.firstapp;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import back.end.*;



public class ListFragment extends Fragment implements View.OnClickListener{
   // Button addItemButton;
//    Button saveButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container,false);

        Button addItemButton = (Button) view.findViewById(R.id.addItemButton);
        addItemButton.setOnClickListener(this); // calling onClick() method
        Button saveButton = (Button) view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked

        Fragment fragment = null;
        Class fragmentClass;
        switch (v.getId()) {

            case R.id.addItemButton:
                fragmentClass = AddItemFragment.class;
                break;

            case R.id.saveButton:
                fragmentClass = SaveFragment.class;
                break;

            default:
                fragmentClass = ListFragment.class;
                break;
        }

        try {
            fragment = (Fragment)fragmentClass.newInstance();
        }catch(Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();


    }
}
