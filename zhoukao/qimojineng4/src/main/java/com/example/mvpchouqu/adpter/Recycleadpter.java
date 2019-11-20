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
import com.example.qimojineng4.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import bean.Ban;
import bean.Rec;

public class Recycleadpter extends RecyclerView.Adapter {
    private List<Rec.ResultsBean> rec;
    private List<Ban> ban;
    private Context context;
    private int RECTEXT = 0;
    private int BANTEXT = 1;

    public Recycleadpter(List<Rec.ResultsBean> rec, List<Ban> ban, Context context) {
        this.rec = rec;
        this.ban = ban;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && ban.size() > 0) {
            return BANTEXT;
        } else {
            return RECTEXT;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        if (position == RECTEXT) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.two, null);
            return new RecycleViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.three, null);
            return new BannerViewHolder(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == RECTEXT) {
            if (ban.size() > 0) {
                position -= 1;
            }
            Rec.ResultsBean resultsBean = rec.get(position);
            ((RecycleViewHolder) holder).tv.setText(resultsBean.getType());
            ((RecycleViewHolder) holder).tv1.setText(resultsBean.getDesc());

        } else {
            ((BannerViewHolder) holder).ba.setImages(ban).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Ban path1 = (Ban) path;
                    Glide.with(context).load(path1.getImage()).into(imageView);
                }
            }).start();
        }
    }

    @Override
    public int getItemCount() {
        return ban.size() > 0 ? rec.size() + 1 : rec.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView tv1;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
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
