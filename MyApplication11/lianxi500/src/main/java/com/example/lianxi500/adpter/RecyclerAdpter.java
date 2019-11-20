package com.example.lianxi500.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lianxi500.R;
import com.example.lianxi500.bean.Food;

import java.util.List;

public class RecyclerAdpter extends RecyclerView.Adapter {
    private Context context;
    private List<Food.DataBean.DatasBean> list;

    public RecyclerAdpter(Context context, List<Food.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.three, null);
        return new RecyclerViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Food.DataBean.DatasBean datasBean = list.get(position);
        ((RecyclerViewHolder) holder).tv.setText(datasBean.getTitle());
        Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecyclerViewHolder) holder).iv);
        
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
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
