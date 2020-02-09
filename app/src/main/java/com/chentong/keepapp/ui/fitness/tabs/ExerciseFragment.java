package com.chentong.keepapp.ui.fitness.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.chentong.keepapp.R;


public class ExerciseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_exercise, container, false);
        final LinearLayout main_layout = root.findViewById(R.id.main_layout);
        RelativeLayout relativeLayout = root.findViewById(R.id.sport_layout);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You made a mess", Toast.LENGTH_LONG).show();
            }
        });

        ImageView body_close = root.findViewById(R.id.body_close);
        final RelativeLayout body_layout = root.findViewById(R.id.body_layout);
        body_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_layout.removeView(body_layout);
            }
        });
        return root;
    }

}
