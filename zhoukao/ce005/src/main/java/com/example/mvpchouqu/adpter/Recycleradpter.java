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
import com.example.ce005.R;

import java.util.List;

import bean.Foods;

public class Recycleradpter extends RecyclerView.Adapter {
    private List<Foods> list;
    private Context context;

    public Recycleradpter(List<Foods> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.six, null);
        return new RecyclerViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Foods foods = list.get(position);
        ((RecyclerViewHolder) holder).tv.setText(foods.getTitle());
        Glide.with(context).load(foods.getUrl()).into(((RecyclerViewHolder) holder).iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv1);
            tv = itemView.findViewById(R.id.tv1);
        }
    }
}
