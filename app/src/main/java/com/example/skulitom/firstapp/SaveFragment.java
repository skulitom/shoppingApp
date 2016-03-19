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
import android.widget.EditText;


public class SaveFragment extends Fragment implements View.OnClickListener{
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_save, container,false);
        Button doneSaveButton = (Button) view.findViewById(R.id.saveListButton);
        doneSaveButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        //do what you want to do when button is clicked
        EditText editTextName = (EditText) view.findViewById(R.id.editSaveList);
        Fragment fragment = null;
        Class fragmentClass;

        if(editTextName.getText().toString().trim().length() > 0) {
            switch (v.getId()) {

                case R.id.saveListButton:
                    fragmentClass = ListFragment.class;
                    break;

                default:
                    fragmentClass = SaveFragment.class;
                    break;
            }

            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
        }
        else{
            editTextName.setError("Name cannot be empty");
        }


    }
}
