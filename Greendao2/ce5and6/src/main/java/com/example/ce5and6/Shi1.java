package com.example.ce5and6;

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
    private List<JieXi> list;
    private Context context;

    public Shi1(List<JieXi> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.five, null);

        ImageView iv = inflate.findViewById(R.id.iv1);
        TextView tv1 = inflate.findViewById(R.id.tv1);
        JieXi jieXi = list.get(i);
        List<JieXi.DataBean.DatasBean> datas = jieXi.getData().getDatas();
        JieXi.DataBean.DatasBean datasBean = datas.get(i);
        String title = datasBean.getTitle();
        Glide.with(context).load(datasBean.getEnvelopePic()).into(iv);
        tv1.setText(title);
        return inflate;
    }
}
