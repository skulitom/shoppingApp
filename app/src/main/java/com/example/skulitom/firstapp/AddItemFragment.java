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



public class AddItemFragment extends Fragment implements View.OnClickListener{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_item, container,false);
        Button doneButton = (Button) view.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked

        Fragment fragment = null;
        Class fragmentClass;
        switch (v.getId()) {

            case R.id.doneButton:
                fragmentClass = ListFragment.class;
                break;

            default:
                fragmentClass = AddItemFragment.class;
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
