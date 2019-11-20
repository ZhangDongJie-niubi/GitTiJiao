package com.example.ce28_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Shi extends BaseAdapter {
    private List<Food.DataBean> list;
    private Context context;

    public Shi(Context context, List<Food.DataBean> data) {
        this.context = context;
    }

    public List<Food.DataBean> getList() {
        return list;
    }

    public void setList(List<Food.DataBean> list) {
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
        convertView = LayoutInflater.from(context).inflate(R.layout.two, null);
        ImageView iv = convertView.findViewById(R.id.iv);
        TextView tv = convertView.findViewById(R.id.tv);
        TextView tv1 = convertView.findViewById(R.id.tv1);
        Food.DataBean dataBean = list.get(position);
        tv.setText(dataBean.getTitle());
        tv.setText(dataBean.getFood_str());
        Glide.with(context).load(dataBean.getPic()).into(iv);
        return convertView;
    }
}
