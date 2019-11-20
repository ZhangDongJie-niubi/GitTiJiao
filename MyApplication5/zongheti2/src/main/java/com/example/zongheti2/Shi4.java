package com.example.zongheti2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Shi4 extends BaseAdapter {
    private List<Phone> list;
    private Context context;

    public Shi4(List<Phone> list, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.thread, null);
        TextView tv4 = convertView.findViewById(R.id.tv4);
        TextView tv5 = convertView.findViewById(R.id.tv5);
        Phone phone = list.get(position);
        tv4.setText(phone.getName());
        tv5.setText(phone.getPhone());
        return convertView;
    }
}
