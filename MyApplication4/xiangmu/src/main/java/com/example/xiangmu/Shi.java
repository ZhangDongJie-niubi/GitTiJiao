package com.example.xiangmu;

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

public class Shi extends RecyclerView.Adapter {
    private Context context;
    private List<Food.DataBean.DatasBean> list=new ArrayList<>();
    private List<BannerBean.DataBean> bannerlist=new ArrayList<>();

    public Shi(Context context) {
        this.context = context;
    }
//刷新
    public void add(List<Food.DataBean.DatasBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    //下拉加載
    public void add1(List<Food.DataBean.DatasBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void lun(List<BannerBean.DataBean> bannerlist) {
        this.bannerlist.clear();
        this.bannerlist.addAll(bannerlist);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.fore, viewGroup,false);
            return new RecyViewHolder(inflate);
        }else{
            View inflate = LayoutInflater.from(context).inflate(R.layout.five, viewGroup,false);
            return new BannerViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof RecyViewHolder){
            if (bannerlist.size()>0){
                i=i-1;
            }
            final Food.DataBean.DatasBean datasBean = list.get(i);
            ((RecyViewHolder) viewHolder).tv.setText(datasBean.getDesc());
            ((RecyViewHolder) viewHolder).tv1.setText(datasBean.getTitle());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onHomeItemClik!=null){
                        onHomeItemClik.clickItem(datasBean);
                    }
                }
            });
        }else{
            ((BannerViewHolder) viewHolder).ban.setImages(bannerlist).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerBean.DataBean dataBean = (BannerBean.DataBean) path;
                    Glide.with(context).load(dataBean.getImagePath()).into(imageView);
                }
            }).start();
        }
    }

    @Override
    public int getItemCount() {
        if (bannerlist.size()>0){
            return 1+list.size();
        }else{
            return list.size();
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position==0&&bannerlist.size()>0){
            return 2;
        }else{
            return 1;
        }

    }





    public class RecyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView tv1;
        public RecyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }
    public class BannerViewHolder extends RecyclerView.ViewHolder {
       Banner ban;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            ban = itemView.findViewById(R.id.ban);
        }
    }





    OnHomeItemClik onHomeItemClik;

    public void setOnHomeItemClik(OnHomeItemClik onHomeItemClik) {
        this.onHomeItemClik = onHomeItemClik;
    }


    public interface OnHomeItemClik{
        void clickItem(Food.DataBean.DatasBean datasBean);
    }
}
