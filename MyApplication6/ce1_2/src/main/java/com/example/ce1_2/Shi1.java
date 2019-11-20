package com.example.ce1_2;

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

public class Shi1 extends RecyclerView.Adapter {
    private List<Rec.DataBean.DatasBean> rec = new ArrayList<>();
    private List<Ban.DataBean> ban = new ArrayList<>();
    private Context context;
    private int RECTEXT = 0;
    private int BANTEXT = 1;

    public Shi1(Context context) {
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

    //    https://wanandroid.com/article/listproject/0/json
//    https://www.wanandroid.com/banner/json
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == RECTEXT) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.six, null);
            return new RecycleViewHolder(inflate);

        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.seleven, null);
            return new RecycleViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == RECTEXT) {
            if (ban.size() > 0) {
                Rec.DataBean.DatasBean datasBean = rec.get(i);
                ((RecycleViewHolder) viewHolder).tv1.setText(datasBean.getTitle());
                ((RecycleViewHolder) viewHolder).tv2.setText(datasBean.getChapterName());
                Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecycleViewHolder) viewHolder).iv2);
            }
        } else {
            ((BannerViewHolder) viewHolder).ba.setImages(ban).setImageLoader(new ImageLoader() {
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
        ImageView iv2;
        TextView tv1;
        TextView tv2;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            iv2 = itemView.findViewById(R.id.iv2);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner ba;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            ba = itemView.findViewById(R.id.ba);
        }
    }
}
