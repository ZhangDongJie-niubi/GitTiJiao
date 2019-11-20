package com.example.zhoumozuoye3;

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
    private Context context;
    private List<Rec.DataBean.DatasBean> rec=new ArrayList<>();
    private List<Ban.DataBean> ban=new ArrayList<>();
    private int RECTEXT=0;
    private int BANYEXT=1;

    public Shi1(Context context) {
        this.context = context;
    }
     public void add(List<Rec.DataBean.DatasBean> rec){
        this.rec.addAll(rec);
        notifyDataSetChanged();
     }
     public void lun(List<Ban.DataBean> ban){
        this.ban.addAll(ban);
        notifyDataSetChanged();
     }
     public void remove(int i){
        rec.remove(i);
        notifyDataSetChanged();
     }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==RECTEXT){
            View inflate = LayoutInflater.from(context).inflate(R.layout.elght, viewGroup, false);
            return new RecyclerViewHolder(inflate);
        }else{
            View inflate = LayoutInflater.from(context).inflate(R.layout.nine, viewGroup, false);
            return new BannerViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
             if (getItemViewType(i)==RECTEXT){
                 if (ban.size()>0){
                     i-=1;
                 }
                 Rec.DataBean.DatasBean datasBean = rec.get(i);
                 ((RecyclerViewHolder)viewHolder).tv4.setText(datasBean.getTitle());
                 ((RecyclerViewHolder)viewHolder).tv5.setText(datasBean.getChapterName());
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
             }else{
                 ((BannerViewHolder)viewHolder).ba.setImages(ban).setImageLoader(new ImageLoader() {
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
        return ban.size()>0?rec.size()+1: rec.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && ban.size() > 0) {
            return BANYEXT;
        }else{
            return RECTEXT;
        }

    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
          TextView tv4;
          TextView tv5;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
             tv4 = itemView.findViewById(R.id.tv4);
             tv5 = itemView.findViewById(R.id.tv5);
        }
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder{
          Banner ba;
        public BannerViewHolder(@NonNull View itemView) {
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

    public interface OnClickListener{
        void onClickListener(int i);
    }
    public interface OnLongClickListener{
        void onLongClickListener(int i);
    }
}
