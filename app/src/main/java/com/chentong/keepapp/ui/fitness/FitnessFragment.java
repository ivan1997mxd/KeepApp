package com.chentong.keepapp.ui.fitness;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.chentong.keepapp.R;
import com.chentong.keepapp.ui.fitness.tabs.BikeFragment;
import com.chentong.keepapp.ui.fitness.tabs.ExerciseFragment;
import com.chentong.keepapp.ui.fitness.tabs.RunFragment;
import com.chentong.keepapp.ui.fitness.tabs.WalkFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FitnessFragment extends Fragment{

    private List<Fragment> list = new ArrayList<>();
    private String[] titles = {"训练","跑步","行走","骑行"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FitnessViewModel fitnessViewModel = ViewModelProviders.of(this).get(FitnessViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fitness, container, false);
        ViewPager viewPager = root.findViewById(R.id.view_page);
        list.add(new ExerciseFragment());
        list.add(new RunFragment());
        list.add(new WalkFragment());
        list.add(new BikeFragment());
        MyAdapter myAdapter = new MyAdapter(getFragmentManager());
        viewPager.setAdapter(myAdapter);
        TabLayout tabLayout = root.findViewById(R.id.tab_layout);
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

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        fragments.add()
//
//        ViewPager viewPager = getView().findViewById(R.id.view_page);
//        viewPager.setAdapter(new FragmentStatePagerAdapter(getFragmentManager()) {
//            @Override
//            public Fragment getItem(int position) {
//                return fragments.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return fragments.size();
//            }
//
//            @Override
//            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//                super.destroyItem(container, position, object);
//            }
//
//            @Nullable
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return titles.get(position);
//            }
//        });
//        TabLayout tabLayout = getView().findViewById(R.id.tab_layout);
//        tabLayout.setupWithViewPager(viewPager);
//    }

}