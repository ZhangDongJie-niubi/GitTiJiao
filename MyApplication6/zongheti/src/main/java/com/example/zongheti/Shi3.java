package com.example.zongheti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Shi3 extends BaseAdapter {
    private Context context;
    private List<ShuL> list;

    public Shi3(Context context, List<ShuL> list) {
        this.context = context;
        this.list = list;
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
        convertView = LayoutInflater.from(context).inflate(R.layout.eleven, null);
        ImageView iv = convertView.findViewById(R.id.iv6);
        EditText ed = convertView.findViewById(R.id.ed);
        EditText ed1 = convertView.findViewById(R.id.ed1);
        ShuL shuL = list.get(position);
        Glide.with(context).load(shuL.getEnvelopepic()).into(iv);
        ed.setText(shuL.getTitle());
        ed1.setText(shuL.getChaptername());
        return convertView;
    }
}
