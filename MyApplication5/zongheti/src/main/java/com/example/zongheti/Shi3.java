package com.example.zongheti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Shi3 extends BaseAdapter {
private List<ShuL> shan ;
private Context context;

    public Shi3(Context context, List<ShuL> shan) {
        this.context = context;
        this.shan=shan;
    }

    @Override
    public int getCount() {
        return shan.size();
    }

    @Override
    public Object getItem(int position) {
        return shan.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.ten, null);
        TextView tt = convertView.findViewById(R.id.tt);
        TextView ttt = convertView.findViewById(R.id.ttt);
        ShuL shuL = shan.get(position);
        tt.setText(shuL.getTitle());
        tt.setText(shuL.getChapterName());
        return convertView;
    }
}
