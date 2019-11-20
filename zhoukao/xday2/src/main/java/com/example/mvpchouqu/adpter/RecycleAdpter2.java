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
import com.bumptech.glide.request.RequestOptions;
import com.example.xday2.R;

import java.util.List;

import bean.Food;

public class RecycleAdpter2 extends RecyclerView.Adapter {
    private List<Food.DataBean> list;
    private Context context;

    public RecycleAdpter2(List<Food.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fore, null);
        return new RecycleAdpter2.RecycleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Food.DataBean dataBean = list.get(position);
        RequestOptions requestOptions = new RequestOptions();
        RequestOptions requestOptions1 = requestOptions.circleCrop();
        Glide.with(context).load(dataBean.getPic()).apply(requestOptions1).into(((RecycleAdpter2.RecycleViewHolder) holder).iv2);
        ((RecycleAdpter2.RecycleViewHolder) holder).tv4.setText(dataBean.getTitle());
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

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        ImageView iv2;
        TextView tv4;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            iv2 = itemView.findViewById(R.id.iv2);
            tv4 = itemView.findViewById(R.id.tv4);
        }

    }

    RecycleAdpter1.OnClickListener onClickListener;
    RecycleAdpter1.OnLongClickListener onLongClickListener;

    public RecycleAdpter1.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(RecycleAdpter1.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public RecycleAdpter1.OnLongClickListener getOnLongClickListener() {
        return onLongClickListener;
    }

    public void setOnLongClickListener(RecycleAdpter1.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public interface OnClickListener {
        void onClickListener(int position);
    }

    public interface OnLongClickListener {
        void onLongClickListener(int position);
    }

}
