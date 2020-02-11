package com.chentong.keepapp.ui.fitness.tabs;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chentong.keepapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeforeFragment extends Fragment {


    public BeforeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_before, container, false);
    }

}
