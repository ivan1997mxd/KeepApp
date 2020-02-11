package com.chentong.keepapp.ui.my;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.fragment.app.FragmentManager;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;

import com.chentong.keepapp.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
