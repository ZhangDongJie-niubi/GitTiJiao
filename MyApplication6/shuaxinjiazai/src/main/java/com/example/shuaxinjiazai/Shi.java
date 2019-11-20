package com.example.shuaxinjiazai;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Shi extends RecyclerView.Adapter {
    private List<Food.DataBean> list = new ArrayList<>();
    private Context context;

    public Shi(List<Food.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
public void add(List<Food.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
}
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.two, viewGroup, false);
        return new RecycliViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Food.DataBean dataBean = list.get(i);
        ((RecycliViewHolder) viewHolder).tv.setText(dataBean.getTitle());
        ((RecycliViewHolder) viewHolder).tv1.setText(dataBean.getCollect_num());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecycliViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView tv1;

        public RecycliViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }

}
