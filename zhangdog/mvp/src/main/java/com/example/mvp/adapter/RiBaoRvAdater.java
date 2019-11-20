package com.example.mvp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvp.R;
import com.example.mvp.base.BaseApp;
import com.example.mvp.model.bean.RiBaoInfo;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RiBaoRvAdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int MTOP_BANNER = 0;
    public static final int MSTORIES_ITEM = 1;

    private List<RiBaoInfo.TopStoriesBean> mTopStories;
    private List<RiBaoInfo.StoriesBean> mStories;
    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mImgs = new ArrayList<String>();

    public RiBaoRvAdater(Context context, List<RiBaoInfo.TopStoriesBean> top_stories,
                         List<RiBaoInfo.StoriesBean> stories) {
        this.mContext = context;
        this.mTopStories = top_stories;
        this.mStories = stories;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BannerViewHolder bannerViewHolder;
        ItemViewViewHolder itemViewViewHolder;
        switch (viewType) {
            case MTOP_BANNER:
                Log.e("TAG", "第0个条目类型");
                View bannerView = mInflater.inflate(R.layout.layout_banner, parent, false);
                bannerViewHolder = new BannerViewHolder(bannerView);
                return bannerViewHolder;
            case MSTORIES_ITEM:
                Log.e("TAG", "其他条目类型");
                View itemView = mInflater.inflate(R.layout.layout_ribao_item, parent, false);
                itemViewViewHolder = new ItemViewViewHolder(itemView);
                return itemViewViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
     for (RiBaoInfo.TopStoriesBean bean : mTopStories) {
            String beanImage = bean.getImage();
            mImgs.add(beanImage);
        }
        if (holder instanceof BannerViewHolder) {
            Log.e("xxx", mImgs.size() + "====集合长度===");
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.banner.setImages(mImgs);
            bannerViewHolder.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                //   RiBaoInfo.TopStoriesBean bean = (RiBaoInfo.TopStoriesBean) path;
                    Glide.with(BaseApp.getContext()).load(path).into(imageView);
                }
            });
            bannerViewHolder.banner.start();
            bannerViewHolder.banner.startAutoPlay();
        } else if (holder instanceof ItemViewViewHolder) {
            ItemViewViewHolder itemViewViewHolder = (ItemViewViewHolder) holder;
            RiBaoInfo.StoriesBean storiesBean = mStories.get(position - 1);
            List<String> images = storiesBean.getImages();
            Glide.with(BaseApp.getContext()).load(images.get(0)).into(itemViewViewHolder.mItemIv);
            itemViewViewHolder.mItemTv.setText(storiesBean.getTitle());
        }

    }

    @Override
    public int getItemCount() {
        return mStories.size() + 1;
    }

    private Unbinder bannderUnbinder;
    private Unbinder itemViewUnbinder;

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        @Nullable
        @BindView(R.id.bannner)
        Banner banner;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            bannderUnbinder = ButterKnife.bind(this, itemView);
        }
    }


    public class ItemViewViewHolder extends RecyclerView.ViewHolder {
        @Nullable
        @BindView(R.id.item_iv_ribao)
        ImageView mItemIv;
        @Nullable
        @BindView(R.id.item_tv_ribao)
        TextView mItemTv;

        public ItemViewViewHolder(@NonNull View itemView) {
            super(itemView);
            itemViewUnbinder = ButterKnife.bind(this, itemView);
        }
    }


    @Override
    public int getItemViewType(int position) {
        Log.e("TAG", position + "===aaaaa==");
        switch (position) {
            case 0:
                return MTOP_BANNER;
            default:
                return MSTORIES_ITEM;
        }
    }

    public void unBind() {
        if (bannderUnbinder != null)
            bannderUnbinder.unbind();
        if (itemViewUnbinder != null)
            itemViewUnbinder.unbind();
    }


}
