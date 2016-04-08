package com.example.skulitom.firstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SeekBar;
import android.widget.TextView;

import back.end.*;



public class AddItemFragment extends Fragment implements View.OnClickListener{
    private View view;
    MyDBHandler dbHandler;
    //SeekBar quantitySeekBar = (SeekBar) findViewById(R.id.seekBar);


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_item, container,false);
        TextView sugestion = (TextView)  view.findViewById(R.id.sugestText);
       // sugestion.addTextChangedListener(dictionaryWatcher);
        Button doneButton = (Button) view.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        TextView sugestion = (TextView)  view.findViewById(R.id.sugestText);
        sugestion.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                TextView sugestion = (TextView)  view.findViewById(R.id.sugestText);
                EditText editTextName = (EditText) view.findViewById(R.id.editTextName);

                ProductsDictionary dictionary = new ProductsDictionary();
                sugestion.setText(dictionary.getCoresponFood(editTextName.getText().toString().trim()));


            }

        });

    }



    @Override
    public void onClick(View v) {
        EditText editTextName = (EditText) view.findViewById(R.id.editTextName);
        EditText editTextPrice = (EditText) view.findViewById(R.id.editTextPrice);

        SeekBar quantitySeekBar = (SeekBar) view.findViewById(R.id.seekBar);

        item currentItem = new item();



        if(editTextPrice.getText().toString().trim().length() > 0 && editTextName.getText().toString().trim().length() > 0) {
            currentItem.setName(editTextName.getText().toString());
            double price = 0;
            int quantity = 1;
            try {
                price = Double.parseDouble(editTextPrice.getText().toString());
            }catch(NumberFormatException e){}
            int pennies = (int)((price-(int)Math.floor(price))*100);
            currentItem.setPounds((int) Math.floor(price));
            currentItem.setPennies(pennies);
            currentItem.setQuantity(quantitySeekBar.getProgress());
            currentItem.setTotalPrice(price);
            dbHandler = new MyDBHandler(getActivity(),null,null,1);
            dbHandler.addItem(currentItem);



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

        }else{
            if(editTextName.getText().toString().trim().length() <= 0) {
                editTextName.setError("Name cannot be empty");
            }
            if(editTextPrice.getText().toString().trim().length() <= 0) {
                editTextPrice.setError("Price cannot be empty");
            }
        }
    }
}
