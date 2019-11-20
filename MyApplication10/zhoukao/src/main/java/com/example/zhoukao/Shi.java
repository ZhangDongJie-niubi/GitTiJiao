package com.example.zhoukao;

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
    private List<Food.DataBean> list = new ArrayList<>();
    private Context context;

    public Shi(Context context) {
        this.context = context;
    }

    public void add(List<Food.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.three, null);
        return new RecycleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        Food.DataBean dataBean = list.get(i);
        ((RecycleViewHolder) viewHolder).tv.setText(dataBean.getTitle());
        ((RecycleViewHolder) viewHolder).tv1.setText(dataBean.getCollect_num());
        Glide.with(context).load(dataBean.getPic()).into(((RecycleViewHolder) viewHolder).iv);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClickListener(i);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClickListener(i);
                }
                return false;
            }
        });
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

    OnClickListener onClickListener;
    OnLongClickListener onLongClickListener;

    public OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public OnLongClickListener getOnLongClickListener() {
        return onLongClickListener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    interface OnClickListener {
        void onClickListener(int i);
    }

    interface OnLongClickListener {
        void onLongClickListener(int i);
    }
}
