package com.chentong.keepapp.ui.share;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.chentong.keepapp.R;
import com.chentong.keepapp.ui.share.tab.HangoutFragment;
import com.chentong.keepapp.ui.share.tab.HotFragment;
import com.chentong.keepapp.ui.share.tab.ScribeFragment;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;
    private List<Fragment> list = new ArrayList<>();
    private String[] titles = {"热门", "关注", "逛逛"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        final ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar_layout);
        TextView barText = actionBar.getCustomView().findViewById(R.id.bar_text);
        barText.setText("动态");
        ImageView barBtn1 = actionBar.getCustomView().findViewById(R.id.bar_btn_1);
        ImageView barBtn2 = actionBar.getCustomView().findViewById(R.id.bar_btn_2);
        barBtn1.setImageResource(R.mipmap.u3879);
        barBtn2.setImageResource(R.mipmap.u3880);

        ViewPager viewPager = root.findViewById(R.id.view_page_2);
        list.add(new HotFragment());
        list.add(new ScribeFragment());
        list.add(new HangoutFragment());
        MyAdapter myAdapter = new MyAdapter(getFragmentManager());
        viewPager.setAdapter(myAdapter);
        TabLayout tabLayout = root.findViewById(R.id.tab_layout_2);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }


    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}