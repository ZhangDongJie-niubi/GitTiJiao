package com.example.zongheti;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Shi2 extends RecyclerView.Adapter {
    //https://www.wanandroid.com/banner/json
    //https://wanandroid.com/article/listproject/0/json
    private List<Rec.DataBean.DatasBean> rec = new ArrayList<>();
    private List<Ban.DataBean> ban = new ArrayList<>();
    private Context context;
    private int RECTEXT = 0;
    private int BANTEXT = 1;

    public Shi2(Context context) {
        this.context = context;
    }

    public void recj(List<Rec.DataBean.DatasBean> rec) {
        this.rec.addAll(rec);
        notifyDataSetChanged();
    }

    public void banj(List<Ban.DataBean> ban) {
        this.ban.addAll(ban);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == RECTEXT) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.eight, null);
            return new RecycleViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.nine, null);
            return new BancycleViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == RECTEXT) {
            if (ban.size() > 0) {
                i -= 1;
            }
            Rec.DataBean.DatasBean datasBean = rec.get(i);
            ((RecycleViewHolder) viewHolder).tv5.setText(datasBean.getTitle());
            ((RecycleViewHolder) viewHolder).tv6.setText(datasBean.getChapterName());
            Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecycleViewHolder) viewHolder).iv5);
            final int finalI = i;
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListener!=null){
                        onClickListener.onClickListener(finalI);
                    }
                }
            });
            final int finalI1 = i;
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onLongClickListener!=null){
                        onLongClickListener.onLongClickListener(finalI1);
                    }
                    return false;
                }
            });
        } else {
            ((BancycleViewHolder) viewHolder).ba.setImages(ban).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Ban.DataBean path1 = (Ban.DataBean) path;
                    Glide.with(context).load(path1.getImagePath()).into(imageView);
                }
            }).start();
        }
    }

    @Override
    public int getItemCount() {
        return ban.size() > 0 ? rec.size() + 1 : rec.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && ban.size() > 0) {
            return BANTEXT;
        } else {
            return RECTEXT;
        }
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        TextView tv5;
        TextView tv6;
        ImageView iv5;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            tv5 = itemView.findViewById(R.id.tv5);
            iv5 = itemView.findViewById(R.id.iv5);
            tv6 = itemView.findViewById(R.id.tv6);
        }
    }

    class BancycleViewHolder extends RecyclerView.ViewHolder {
        Banner ba;

        public BancycleViewHolder(@NonNull View itemView) {
            super(itemView);
            ba = itemView.findViewById(R.id.ba);
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
    interface OnClickListener{
        void onClickListener(int i);
    }
    interface OnLongClickListener{
        void onLongClickListener(int i);
    }
}
