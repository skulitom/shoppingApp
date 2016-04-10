package com.example.skulitom.firstapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import back.end.MyDBHandler;


public class HomeFragment extends Fragment implements View.OnClickListener{
    private Button startButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);
        startButton = (Button) view.findViewById(R.id.create_new_list_button);
        startButton.setOnClickListener(this);
        final Button USAButton = (Button) view.findViewById(R.id.USAButton);
        final Button UKButton = (Button) view.findViewById(R.id.UKButton);
        USAButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //- 1 == USA
                ((MainActivity)getActivity()).setLang(1);
                USAButton.setText("OK");
                UKButton.setText("UK");
            }
        });
        UKButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //- 0 == UK
                ((MainActivity)getActivity()).setLang(0);
                USAButton.setText("USA");
                UKButton.setText("OK");
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked
        MyDBHandler dbHandler = new MyDBHandler(getActivity(),null,null,1);
        Fragment fragment = null;
        Class fragmentClass = ListFragment.class;
        try {
            fragment = (Fragment)fragmentClass.newInstance();
            dbHandler.dropList();
        }catch(Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

    }
}
