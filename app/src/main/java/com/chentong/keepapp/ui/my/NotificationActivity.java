package com.chentong.keepapp.ui.my;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.chentong.keepapp.R;
import com.chentong.keepapp.ui.my.tab.NotificationFragment;
import com.chentong.keepapp.ui.my.tab.settingFragment;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.action_bar_tab);
        ImageView back_btn = actionBar.getCustomView().findViewById(R.id.back_img);
        RadioGroup noti_group = actionBar.getCustomView().findViewById(R.id.noti_group);
        RadioButton setting_tab = actionBar.getCustomView().findViewById(R.id.setting_tab);
        RadioButton notification_tab = actionBar.getCustomView().findViewById(R.id.notification_tab);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setting_tab.setChecked(true);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_content, new settingFragment());
        transaction.commit();
        noti_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                if (checkedId == R.id.setting_tab){
                    transaction1.replace(R.id.fl_content, new settingFragment());
                }else if (checkedId == R.id.notification_tab){
                    transaction1.replace(R.id.fl_content, new NotificationFragment());
                }
                transaction1.commit();
            }
        });

    }

}
