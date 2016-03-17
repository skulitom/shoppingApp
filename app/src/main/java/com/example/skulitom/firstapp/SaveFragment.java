package com.example.skulitom.firstapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SaveFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SaveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaveFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_save, container,false);
        return view;
    }
}
