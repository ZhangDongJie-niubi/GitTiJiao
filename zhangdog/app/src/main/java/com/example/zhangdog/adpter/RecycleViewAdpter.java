package com.example.zhangdog.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhangdog.R;
import com.example.zhangdog.bean.Food;

import java.util.List;

public class RecycleViewAdpter extends RecyclerView.Adapter {
    private Context context;
    private List<Food.DataBean.DatasBean> list;

    public RecycleViewAdpter(Context context, List<Food.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.two, null);
        return new RecycleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Food.DataBean.DatasBean datasBean = list.get(i);
        Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecycleViewHolder) viewHolder).iv);
        ((RecycleViewHolder) viewHolder).tv.setText(datasBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
