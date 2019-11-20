package com.example.ce21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Shi1 extends BaseAdapter {
    private List<Food.DataBean> list;
    private Context context;

    public List<Food.DataBean> getList() {
        return list;
    }

    public void setList(List<Food.DataBean> list) {
        this.list = list;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Shi1(List<Food.DataBean> list, Context context) {
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.three, null);
        ImageView im = inflate.findViewById(R.id.im);
        TextView te = inflate.findViewById(R.id.te);

        Food.DataBean dataBean = list.get(position);
        te.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getPic()).into(im);
        return inflate;
    }
}
