package com.chentong.keepapp.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.chentong.keepapp.R;

public class MyFragment extends Fragment {
    private MyViewModel myViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myViewModel =
                ViewModelProviders.of(this).get(MyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_my, container, false);
        final ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_me);
        TextView barText = actionBar.getCustomView().findViewById(R.id.bar_text_me);
        barText.setText("我");
        ImageView barBtn1 = actionBar.getCustomView().findViewById(R.id.bar_img_1);
        ImageView barBtn2 = actionBar.getCustomView().findViewById(R.id.bar_img_2);
        ImageView barBtn3 = actionBar.getCustomView().findViewById(R.id.bar_img_3);
        barBtn1.setImageResource(R.mipmap.u4362);
        barBtn2.setImageResource(R.mipmap.u4363);
        barBtn3.setImageResource(R.mipmap.u4369);
        barBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
        barBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NotificationActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}
