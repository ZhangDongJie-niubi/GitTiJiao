package com.example.shuzujiexi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Shi extends BaseAdapter {
    private List<Food> list;
    private Context context;

    public Shi(List<Food> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.two, null);
        TextView tv = convertView.findViewById(R.id.tv);
        TextView tv1 = convertView.findViewById(R.id.tv1);
        Food food = list.get(position);
        tv.setText(food.getSuperChapterName());
        tv1.setText(food.getDesc());
        return convertView;
    }
}
