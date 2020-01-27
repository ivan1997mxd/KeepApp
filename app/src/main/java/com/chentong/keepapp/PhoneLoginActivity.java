package com.chentong.keepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PhoneLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);
    }
    public void PhoneLogin(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
