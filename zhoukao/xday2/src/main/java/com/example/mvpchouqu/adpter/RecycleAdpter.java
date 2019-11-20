package com.example.mvpchouqu.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xday2.R;

import java.util.List;

import bean.Food;

public class RecycleAdpter extends RecyclerView.Adapter {
    private List<Food.DataBean> list;
    private Context context;

    public RecycleAdpter(List<Food.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.two, null);
        return new RecycleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Food.DataBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.getPic()).into(((RecycleViewHolder) holder).iv);
        ((RecycleViewHolder) holder).tv.setText(dataBean.getTitle());
        ((RecycleViewHolder) holder).tv1.setText(dataBean.getFood_str());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        TextView tv1;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
        }

    }
}
