package com.example.qimojineng3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Shi extends RecyclerView.Adapter {
    private List<Food.ResultsBean> list;
    private Context context;

    public Shi(List<Food.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.three, viewGroup, false);
        return new RecycleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Food.ResultsBean resultsBean = list.get(i);
        Glide.with(context).load(resultsBean.getUrl()).into(((RecycleViewHolder) viewHolder).iv2);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        ImageView iv2;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            iv2 = itemView.findViewById(R.id.iv2);
        }
    }
}
