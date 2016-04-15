package com.example.skulitom.firstapp;


import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import back.end.*;



public class ListFragment extends Fragment implements View.OnClickListener{

    private MyDBHandler dbHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container,false);
        Currency currency = new Currency();
        currency.setCurrency(((MainActivity)getActivity()).getLang());

        dbHandler = new MyDBHandler(getActivity(),null,null,1);
        // Create a LinearLayout element
        final LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.LinearLayoutScrollCL);

            int i = 0;
            itemList dbItemList = dbHandler.databaseGetList("Current List");

            while(i<dbItemList.getItemListLength()){
                PriceColor priceColor = new PriceColor();
                final Button button = new Button(this.getActivity());
                final String buttonName = dbItemList.getItem(i).getName().toLowerCase().trim();
                String bText = dbItemList.getItem(i).getName()+" : "+currency.getSymbol()+addZeroToDouble(dbItemList.getItem(i).getTotalPrice());
                Log.d("movie:android",dbItemList.getItem(i).getName());
                button.setText(bText);
                button.setGravity(Gravity.CENTER);
                button.setBackgroundColor(Color.rgb(255, 255, 255));
                button.setTextColor(Color.rgb(0, priceColor.getItemGreen(dbItemList.getItem(i).getTotalPrice()), 0));
                button.setHighlightColor(Color.DKGRAY);
                button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                button.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        button.setText("Delete Item?");
                        button.setTextColor(Color.BLACK);
                        button.setBackgroundResource(android.R.drawable.btn_default);
                        button.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View v) {
                                dbHandler.deleteItem(buttonName);
                                Log.d("android:HELP",buttonName);
                                linearLayout.removeView(button);
                            }
                        });
                    }
                });
                linearLayout.addView(button);

                i++;

        }

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

    String addZeroToDouble(Double number){
        String result = "";
        Double roundedNumber = Math.floor(number)+((double)Math.round((number - Math.floor(number))*100))/100;
        result = Double.toString(roundedNumber);
        if(result.charAt(result.length()-2)=='.'){
            result+="0";
        }
        return result;
    }
}
