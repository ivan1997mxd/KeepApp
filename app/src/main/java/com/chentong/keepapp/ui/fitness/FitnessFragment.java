package com.chentong.keepapp.ui.fitness;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.chentong.keepapp.R;

public class FitnessFragment extends Fragment {

    private FitnessViewModel fitnessViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fitnessViewModel =
                ViewModelProviders.of(this).get(FitnessViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fitness, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        fitnessViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}