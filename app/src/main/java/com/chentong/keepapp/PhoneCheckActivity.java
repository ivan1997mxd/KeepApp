package com.chentong.keepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PhoneCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_check);
    }

    public void UserRegister(View view){
        Intent intent = new Intent(this,PhoneRegisterActivity.class);
        startActivity(intent);
    }
}
