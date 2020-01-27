package com.chentong.keepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import net.rimoto.intlphoneinput.IntlPhoneInput;

public class PhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        IntlPhoneInput phoneInputView = findViewById(R.id.my_phone_input);
        String myInternationalNumber = "";
        if(phoneInputView.isValid()) {
            myInternationalNumber = phoneInputView.getNumber();
        }
        System.out.println(myInternationalNumber);
    }

    public void PhoneCheck(View view){
        Intent intent = new Intent(this,PhoneCheckActivity.class);
        startActivity(intent);
    }
}
