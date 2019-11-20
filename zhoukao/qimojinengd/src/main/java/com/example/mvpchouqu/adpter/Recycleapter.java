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
import com.example.qimojinengd.R;

import java.util.List;

import bean.Food;

public class Recycleapter extends RecyclerView.Adapter {
    private List<Food.DataBean.DatasBean> list;
    private Context context;
    private int YITEXT = 0;
    private int ERTEXT = 1;

    public Recycleapter(List<Food.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return YITEXT;
        } else {
            return ERTEXT;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (i == YITEXT) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.three, null);
            return new YiViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.fore, null);
            return new ErViewHolder(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Food.DataBean.DatasBean datasBean = list.get(position);
        if (getItemViewType(position) == YITEXT) {
            Glide.with(context).load(datasBean.getEnvelopePic()).into(((YiViewHolder) holder).iv);
            ((YiViewHolder) holder).tv.setText(datasBean.getDesc());
        } else {
            ((ErViewHolder) holder).tv1.setText(datasBean.getDesc());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClickListener(position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClickListener(position);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class YiViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;

        public YiViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    class ErViewHolder extends RecyclerView.ViewHolder {
        TextView tv1;

        public ErViewHolder(@NonNull View itemView) {
            super(itemView);
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

    public interface OnClickListener {
        void onClickListener(int position);
    }

    public interface OnLongClickListener {
        void onLongClickListener(int position);
    }
}
