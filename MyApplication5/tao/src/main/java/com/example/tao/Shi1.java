package com.example.tao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Shi1 extends RecyclerView.Adapter {
    private List<Er.DataBean.DatasBean> datasBeans=new ArrayList<>();
    private Context context;

    public Shi1(Context context) {
        this.context = context;
    }
    public void add(List<Er.DataBean.DatasBean> datasBeans){
        this.datasBeans.addAll(datasBeans);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fore, null);
        return new RecycleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Er.DataBean.DatasBean datasBean = datasBeans.get(i);
        ((RecycleViewHolder)viewHolder).tv.setText(datasBean.getTitle());
        ((RecycleViewHolder)viewHolder).tv1.setText(datasBean.getChapterName());
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        TextView tv1;
        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }
}
