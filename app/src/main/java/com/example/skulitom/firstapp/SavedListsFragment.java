package com.example.skulitom.firstapp;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
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
    MyDBHandler dbHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_saved_lists, container,false);

        ScrollView scrollView = (ScrollView)view.findViewById(R.id.scrollViewSavedLists);
       // scrollView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));

        dbHandler = new MyDBHandler(getActivity(),null,null,1);
        // Create a LinearLayout element
        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.LinearLayoutScrollSL);
      //  linearLayout.setOrientation(LinearLayout.VERTICAL);
      //  linearLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        int i = 0;
        ListOfLists dbListOfLists = dbHandler.databaseAllLists();
        while(i<dbListOfLists.getItemListLength()){

            Button button = new Button(this.getActivity());

            button.setText(dbListOfLists.getItem(i).getName());
            button.setGravity(Gravity.CENTER);
            button.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Fragment fragment = null;
                    Class fragmentClass = ListFragment.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                        //dbHandler.dropList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

                }
            });
            linearLayout.addView(button);

            i++;

        }
        //scrollView.addView(linearLayout);
        return view;
    }
}
