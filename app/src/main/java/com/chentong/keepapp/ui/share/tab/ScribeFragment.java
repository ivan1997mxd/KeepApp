package com.chentong.keepapp.ui.share.tab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chentong.keepapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScribeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScribeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScribeFragment extends Fragment {

    public ScribeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scribe, container, false);
    }

}
