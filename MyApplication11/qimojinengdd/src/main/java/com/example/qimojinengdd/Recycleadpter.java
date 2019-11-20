package com.example.qimojinengdd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Recycleadpter extends RecyclerView.Adapter {
    private List<Food.DataBean.DatasBean> list = new ArrayList<>();
    private Context context;
    private int M = 0;
    private int MM = 1;

    public Recycleadpter(Context context) {

        this.context = context;
    }

    public void jia(List<Food.DataBean.DatasBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return M;
        } else {
            return MM;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        if (position == M) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.three, parent, false);
            return new RecycleViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.five, parent, false);
            return new RecyclerViewHolder1(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Food.DataBean.DatasBean datasBean = list.get(position);
        if (getItemViewType(position) == M) {
            ((RecycleViewHolder) holder).tv1.setText(datasBean.getDesc());
            Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecycleViewHolder) holder).iv1);
        } else {
            ((RecyclerViewHolder1) holder).tv2.setText(datasBean.getDesc());
        }
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClickListener(position);
                }
                return false;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClickListener(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        ImageView iv1;
        TextView tv1;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.iv1);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }

    class RecyclerViewHolder1 extends RecyclerView.ViewHolder {
        TextView tv2;

        public RecyclerViewHolder1(@NonNull View itemView) {
            super(itemView);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }

    OnLongClickListener onLongClickListener;
    OnClickListener onClickListener;

    public OnLongClickListener getOnLongClickListener() {
        return onLongClickListener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    interface OnClickListener {
        void onClickListener(int position);
    }

    interface OnLongClickListener {
        void onLongClickListener(int position);
    }
}
