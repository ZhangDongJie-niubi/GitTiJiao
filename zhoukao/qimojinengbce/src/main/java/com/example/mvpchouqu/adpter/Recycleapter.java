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
import com.example.qimojinengbce.R;

import java.util.List;

import bean.Food;

public class Recycleapter extends RecyclerView.Adapter {
    private List<Food.DataBean.DatasBean> list;
    private Context context;
    private int M=0;
    private int MM=1;

    public Recycleapter(List<Food.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        Food.DataBean.DatasBean datasBean = list.get(position);
        if (datasBean.getId() % 3 == 0) {
            return M;
        } else {
            return MM;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        if (position == M) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.three, null);
            return new YiViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.fore, null);
            return new ErViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
          Food.DataBean.DatasBean  datasBean = list.get(position);
        if (getItemViewType(position) == M) {
            ((YiViewHolder) holder).tv.setText(datasBean.getTitle());
            ((YiViewHolder) holder).tv1.setText(datasBean.getId() + "");
            Glide.with(context).load(datasBean.getEnvelopePic()).into(((YiViewHolder) holder).iv);
        } else {
            ((ErViewHolder) holder).tv2.setText(datasBean.getTitle());
            ((ErViewHolder) holder).tv3.setText(datasBean.getId() + "");
            Glide.with(context).load(datasBean.getEnvelopePic()).into(((ErViewHolder) holder).iv1);
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
        TextView tv1;

        public YiViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }

    class ErViewHolder extends RecyclerView.ViewHolder {
        ImageView iv1;
        TextView tv2;
        TextView tv3;

        public ErViewHolder(@NonNull View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.iv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
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
