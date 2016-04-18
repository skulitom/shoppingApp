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
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.view.ViewGroup.LayoutParams;
import android.widget.Switch;

import back.end.*;


public class SavedListsFragment extends Fragment {
    private View view;
    private MyDBHandler dbHandler;
    private boolean deleteList = false;
    private Switch deleteListSwitch;
    private LinearLayout linearLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_saved_lists, container,false);
        linearLayout = (LinearLayout) view.findViewById(R.id.LinearLayoutSavedLists);
        deleteListSwitch = (Switch) view.findViewById(R.id.deleteListsSwitch);
        ScrollView scrollView = (ScrollView)view.findViewById(R.id.scrollViewSavedLists);
       // scrollView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));

        dbHandler = new MyDBHandler(getActivity(),null,null,1);
        // Create a LinearLayout element
        final LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.LinearLayoutScrollSL);
      //  linearLayout.setOrientation(LinearLayout.VERTICAL);
      //  linearLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        int i = 0;
        ListOfLists dbListOfLists = dbHandler.databaseAllLists();
        while(i<dbListOfLists.getItemListLength()){

            final Button button = new Button(this.getActivity());

            button.setText(dbListOfLists.getItem(i).getName());
            button.setGravity(Gravity.CENTER);
            button.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (!deleteList) {
                        itemList itemList = dbHandler.databaseGetList(button.getText().toString());
                        dbHandler.dropList();
                        for (int i = 0; i < itemList.getItemListLength(); i++) {
                            item item;
                            item = itemList.getItem(i);
                            item.setListName("Current List");
                            dbHandler.addItem(item);
                        }
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
                    } else {
                        dbHandler.deleteList(button.getText().toString().toString().trim());
                        linearLayout.removeView(button);
                    }

                }
            });
            linearLayout.addView(button);

            i++;

        }


        deleteListSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    deleteList = true;
                } else {
                    // The toggle is disabled
                    deleteList = false;

                }
            }
        });
        return view;
    }
}
