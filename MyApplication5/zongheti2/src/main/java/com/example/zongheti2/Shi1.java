package com.example.zongheti2;

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
    private List<Ban.DataBean> ban = new ArrayList<>();
    private List<Src.DataBean.DatasBean> src = new ArrayList<>();
    private Context context;
    private int SRCTEXT=0;
    private int BANTEXT=1;

    public Shi1(Context context) {
        this.context = context;
    }


    public void banj(List<Ban.DataBean> ban) {
        this.ban.addAll(ban);
        notifyDataSetChanged();
    }

    public void srcj(List<Src.DataBean.DatasBean> src) {
        this.src.addAll(src);
        notifyDataSetChanged();
    }
    public void shan(int i){
        this.src.remove(i);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == SRCTEXT) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.sereven, viewGroup,false);
            return new RecycleView(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.eight, viewGroup,false);
            return new BannerView(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == SRCTEXT) {
            if (ban.size() > 0) {
                i -= 1;
            }
            Src.DataBean.DatasBean datasBean = src.get(i);
            ((RecycleView) viewHolder).tv1.setText(datasBean.getTitle());
            ((RecycleView) viewHolder).tv2.setText(datasBean.getChapterName());
            final int finalI = i;
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListener != null) {
                        onClickListener.onClickListener(finalI);
                    }
                }
            });
            final int finalI1 = i;
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onLongClickListener != null) {
                        onLongClickListener.onLongClickListener(finalI1);
                    }
                    return false;
                }
            });
        }else{
            ((BannerView)viewHolder).ba.setImages(ban).setImageLoader(new ImageLoader() {
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
        return ban.size() > 0 ? src.size() + 1 : src.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (ban.size() > 0 && position == 0) {
            return BANTEXT;
        } else {
            return SRCTEXT;
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
        void onClickListener(int i);
    }

    public interface OnLongClickListener {
        void onLongClickListener(int i);

    }

    public class RecycleView extends RecyclerView.ViewHolder {
        TextView tv1;
        TextView tv2;

        public RecycleView(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }


    public class BannerView extends RecyclerView.ViewHolder {
        Banner ba;

        public BannerView(@NonNull View itemView) {
            super(itemView);
            ba = itemView.findViewById(R.id.ba);
        }
    }


}
