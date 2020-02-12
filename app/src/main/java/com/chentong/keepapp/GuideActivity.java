package com.chentong.keepapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    ViewPager viewpager;
    List<View> listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewpager = findViewById(R.id.view_pager);

        listview = new ArrayList<>();
        for (int i = 0; i < 3; i++) {

            View view = LayoutInflater.from(this).inflate(R.layout.layout_viewpager, null);
            TextView textView = view.findViewById(R.id.text_view);
            ImageView imageView = view.findViewById(R.id.image_view);

            switch (i) {
                case 0:
                    imageView.setImageResource(R.drawable.ic_u401);
                    textView.setText("丰富的训练内容");
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.ic_u401);
                    textView.setText("精准的跑步和骑行记录");
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.ic_u401);
                    textView.setText("记录你的健康数据");
                    break;

            }
            listview.add(view);

        }
        viewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return listview.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
//                return false;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(listview.get(position));
                return listview.get(position);
//                return super.instantiateItem(container, position);
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//                super.destroyItem(container, position, object);
                container.removeView(listview.get(position));
            }
        });

    }

    public void goLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void goRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
