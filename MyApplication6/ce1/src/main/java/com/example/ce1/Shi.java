package com.example.ce1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Shi extends RecyclerView.Adapter {
    private int M = 0;
    private int MM = 1;
    private List<Food.DataBean.DatasBean> list = new ArrayList<>();
    private Context context;

    public Shi(Context context) {
        this.context = context;
    }

    public void add(List<Food.DataBean.DatasBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == M) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.five, null);
            return new RecycleViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.six, null);
            return new RecycleViewHolder1(inflate);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return M;
        } else {
            return MM;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == M) {
            Food.DataBean.DatasBean datasBean = list.get(i);
            Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecycleViewHolder) viewHolder).iv1);
            ((RecycleViewHolder) viewHolder).tv1.setText(datasBean.getTitle());
            ((RecycleViewHolder) viewHolder).tv2.setText(datasBean.getChapterName());
        } else {
            Food.DataBean.DatasBean datasBean = list.get(i);
            Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecycleViewHolder1) viewHolder).iv2);
            Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecycleViewHolder1) viewHolder).iv3);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        ImageView iv1;
        TextView tv1;
        TextView tv2;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.iv1);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }

    class RecycleViewHolder1 extends RecyclerView.ViewHolder {
        ImageView iv2;
        ImageView iv3;

        public RecycleViewHolder1(@NonNull View itemView) {
            super(itemView);
            iv2 = itemView.findViewById(R.id.iv2);
            iv3 = itemView.findViewById(R.id.iv3);
        }
    }
}
