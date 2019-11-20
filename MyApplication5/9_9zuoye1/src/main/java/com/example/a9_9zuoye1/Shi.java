package com.example.a9_9zuoye1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Shi extends RecyclerView.Adapter {
private List<Rec.DataBean.DatasBean> list=new ArrayList<>();
private Context context;

    public Shi(  Context context) {
        this.context = context;
    }


    public void add(List<Rec.DataBean.DatasBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.three, viewGroup, false);

        return new RecyclerViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Rec.DataBean.DatasBean datasBean = list.get(i);
        ((RecyclerViewHolder)viewHolder).tv.setText(datasBean.getTitle());
        ((RecyclerViewHolder)viewHolder).tv1.setText(datasBean.getChapterName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView tv1;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
             tv = itemView.findViewById(R.id.tv);
             tv1 = itemView.findViewById(R.id.tv1);
        }
    }
}
