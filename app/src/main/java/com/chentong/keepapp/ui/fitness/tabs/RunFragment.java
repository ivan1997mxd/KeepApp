package com.chentong.keepapp.ui.fitness.tabs;


import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.chentong.keepapp.R;

import java.util.ArrayList;
import java.util.List;

public class RunFragment extends Fragment {

    private List<RunAct> runActs = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_run, container, false);
        init();
        RunActAdapter adapter = new RunActAdapter(root.getContext(), R.layout.activities_item, runActs);
        ListView listView = root.findViewById(R.id.run_activity_list);
        setListViewHeightBasedOnChildren(listView, adapter);
        listView.setAdapter(adapter);
        return root;

    }

    private void init() {
        runActs.add(new RunAct("分段跑·初级燃脂", "25分钟快慢跑交替，燃脂230-318大卡", R.drawable.ic_u936));
        runActs.add(new RunAct("分段跑·进阶燃脂", "29分钟快慢跑交替，燃脂271-357大卡", R.drawable.ic_u936));
        runActs.add(new RunAct("分段跑·HIIT强化燃脂", "35分钟快慢跑交替，燃脂352-509大卡", R.drawable.ic_u936));
    }

    private static void setListViewHeightBasedOnChildren(ListView listView, RunActAdapter adapter) {
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView); // listItem.measure(0, 0);
            listItem.measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}

