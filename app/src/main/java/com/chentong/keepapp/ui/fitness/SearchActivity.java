package com.chentong.keepapp.ui.fitness;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chentong.keepapp.R;
import com.chentong.keepapp.ui.fitness.tabs.BeforeFragment;
import com.chentong.keepapp.ui.fitness.tabs.NowFragment;
import com.chentong.keepapp.ui.my.tab.settingFragment;

public class SearchActivity extends AppCompatActivity {

    String input = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.action_bar_search);
        final ImageView btn_cancel = actionBar.getCustomView().findViewById(R.id.search_cancel);
        final ImageView btn_back = actionBar.getCustomView().findViewById(R.id.search_back);
        final ImageView btn_icon = actionBar.getCustomView().findViewById(R.id.search_icon);
        btn_back.setVisibility(View.VISIBLE);
        btn_icon.setVisibility(View.INVISIBLE);
        btn_cancel.setVisibility(View.INVISIBLE);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.f2_content, new BeforeFragment());
        transaction.commit();
        final EditText search_content = actionBar.getCustomView().findViewById(R.id.search_input);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_content.setText("");
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        search_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() != 0) {
                    btn_cancel.setVisibility(View.VISIBLE);
                    btn_back.setVisibility(View.INVISIBLE);
                    btn_icon.setVisibility(View.VISIBLE);
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.f2_content, new NowFragment());
                    transaction.commit();
                }else {
                    btn_back.setVisibility(View.VISIBLE);
                    btn_icon.setVisibility(View.INVISIBLE);
                    btn_cancel.setVisibility(View.INVISIBLE);
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.f2_content, new BeforeFragment());
                    transaction.commit();
                }
            }
        });


    }
}
