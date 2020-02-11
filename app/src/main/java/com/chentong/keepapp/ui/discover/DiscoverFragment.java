package com.chentong.keepapp.ui.discover;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.chentong.keepapp.R;
import com.chentong.keepapp.ui.discover.tab.CityFragment;
import com.chentong.keepapp.ui.discover.tab.FoodFragment;
import com.chentong.keepapp.ui.discover.tab.PlanFragment;
import com.chentong.keepapp.ui.discover.tab.SelectFragment;
import com.chentong.keepapp.ui.discover.tab.ShopFragment;
import com.chentong.keepapp.ui.discover.tab.TrainFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {

    private DiscoverViewModel discoverViewModel;
    private List<Fragment> list = new ArrayList<>();
    private String[] titles = {"精选","训练","攻略","饮食","商城","同城"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        discoverViewModel =
                ViewModelProviders.of(this).get(DiscoverViewModel.class);
        View root = inflater.inflate(R.layout.fragment_discover, container, false);
        final ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.action_bar_search);
        actionBar.getCustomView().findViewById(R.id.search_cancel).setVisibility(View.INVISIBLE);
        ViewPager viewPager = root.findViewById(R.id.view_page_1);
        list.add(new SelectFragment());
        list.add(new TrainFragment());
        list.add(new PlanFragment());
        list.add(new FoodFragment());
        list.add(new ShopFragment());
        list.add(new CityFragment());
        MyAdapter myAdapter = new MyAdapter(getFragmentManager());
        viewPager.setAdapter(myAdapter);
        TabLayout tabLayout = root.findViewById(R.id.tab_layout_1);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.options_menu,menu);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.ab_search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

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