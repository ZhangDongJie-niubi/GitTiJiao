package com.example.lianxi1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Shi extends BaseAdapter {
private List<Phone> arr;
private Context context;

    public Shi(List<Phone> arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
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
        Phone phone = arr.get(position);
        tv.setText(phone.getName());
        tv.setText(phone.getPhone());
        return convertView;
    }
}
