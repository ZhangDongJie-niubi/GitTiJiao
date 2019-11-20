package com.example.zhoumozuoye1;

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
    List<Rec.DataBean.DatasBean> rec = new ArrayList<>();
    List<Ban.DataBean> ban = new ArrayList<>();
    public final int VIEW_TEXT = 0;
    public final int VIEW_BAR = 1;

    public void delete(int i) {
        this.rec.remove(i);
        notifyDataSetChanged();
    }

    public Shi1(Context context) {
        this.context = context;
    }


    public void lun(List<Ban.DataBean> ban) {
        this.ban.addAll(ban);
        notifyDataSetChanged();
    }

    public void add(List<Rec.DataBean.DatasBean> rec) {
        this.rec.addAll(rec);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == VIEW_TEXT) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.seleven, viewGroup, false);
            return new RecycleViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.eight, viewGroup, false);
            return new BannerViewHolder(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final int finalI = i;
        if (getItemViewType(i) == VIEW_TEXT) {
            if (ban.size() > 0) {
                i -= 1;
            }
            Rec.DataBean.DatasBean datasBean = rec.get(i);
            ((RecycleViewHolder) viewHolder).tv.setText(datasBean.getTitle());
            ((RecycleViewHolder) viewHolder).tv1.setText(datasBean.getChapterName());

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onHomeItemClik != null) {
                        onHomeItemClik.clikcItem(finalI);
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
            return VIEW_BAR;
        } else {
            return VIEW_TEXT;
        }
    }


    public class RecycleViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView tv1;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner ba;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            ba = itemView.findViewById(R.id.ba);
        }
    }


    OnHomeItemClik onHomeItemClik;


    public void setOnHomeItemlick(OnHomeItemClik onHomeItemCli4k) {
        this.onHomeItemClik = onHomeItemClik;
    }

    public interface OnHomeItemClik {
        void clikcItem(int i);
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
