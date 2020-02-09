package com.chentong.keepapp.ui.fitness.tabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chentong.keepapp.R;

import java.util.List;

public class RunActAdapter extends ArrayAdapter<RunAct> {

    private int resourceId;

    public RunActAdapter(@NonNull Context context, int resource, @NonNull List<RunAct> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RunAct runAct = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ((ImageView) view.findViewById(R.id.item_image)).setImageResource(runAct.getImageID());
        ((TextView) view.findViewById(R.id.item_title)).setText(runAct.getTitle());
        ((TextView) view.findViewById(R.id.item_content)).setText(runAct.getContent());
        return view;
    }
}
