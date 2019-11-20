package com.example.mvpchouqu.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.qimojinengbce.R;


import java.util.List;

import bean.Fuli;

public class Fuliapter extends PagerAdapter {
private List<Fuli.ResultsBean> list;
private Context context;

    public Fuliapter(List<Fuli.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Fuli.ResultsBean resultsBean = list.get(position);
        View inflate = LayoutInflater.from(context).inflate(R.layout.five, null);
        ImageView iv2 = inflate.findViewById(R.id.iv2);
        Glide.with(context).load(resultsBean.getUrl()).into(iv2);
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
