package com.example.tao2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Shi1 extends BaseAdapter {
    private List<ShuL> list;
    private Context context;

    public Shi1(List<ShuL> list, Context context) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.five, null);
        TextView tv2 = convertView.findViewById(R.id.tv2);
        TextView tv3 = convertView.findViewById(R.id.tv3);
        ShuL shuL = list.get(position);
        tv2.setText(shuL.getTitle());
        tv3.setText(shuL.getChapterName());
        return convertView;
    }
}
