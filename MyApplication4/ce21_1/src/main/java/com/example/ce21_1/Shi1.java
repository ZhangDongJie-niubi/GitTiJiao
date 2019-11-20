package com.example.ce21_1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Shi1 extends RecyclerView.Adapter {
    private int M = 0;
    private int MM = 1;
    private int MMM = 2;
    private List<Food.DataBean> food = new ArrayList<>();
    private Context context;

    public Shi1(Context context) {
        this.context = context;
    }

    public List<Food.DataBean> getFood() {
        return food;
    }

    public void add(List<Food.DataBean> food) {
        this.food = food;
        notifyDataSetChanged();
    }

    public void setFood(List<Food.DataBean> food) {
        this.food = food;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == M) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.three, viewGroup, false);
            return new ViewHolder(inflate);
        } else if (i == MM) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.fore, viewGroup, false);
            return new ViewHolderText(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.five, viewGroup, false);
            return new ViewHolderDesc(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        Food.DataBean dataBean = food.get(i);
        if (getItemViewType(i) == M) {
            Glide.with(context).load(dataBean.getPic()).into(((ViewHolder) viewHolder).iv);
            ((ViewHolder) viewHolder).tv1.setText(dataBean.getTitle());
            ((ViewHolder) viewHolder).tv2.setText(dataBean.getFood_str());
        } else if (getItemViewType(i) == MM) {
            ((ViewHolderText) viewHolder).tv3.setText(dataBean.getTitle());
            Glide.with(context).load(dataBean.getPic()).into(((ViewHolderText) viewHolder).iv1);
            Glide.with(context).load(dataBean.getPic()).into(((ViewHolderText) viewHolder).iv2);
            Glide.with(context).load(dataBean.getPic()).into(((ViewHolderText) viewHolder).iv3);
        } else {
            Glide.with(context).load(dataBean.getPic()).into(((ViewHolderDesc) viewHolder).iv4);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClickListener(i);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClickListener(i);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return M;
        } else if (position % 3 == 1) {
            return MM;
        } else {
            return MMM;
        }
    }

    @Override
    public int getItemCount() {
        return food.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1;
        TextView tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }

    public class ViewHolderText extends RecyclerView.ViewHolder {
        TextView tv3;
        ImageView iv1;
        ImageView iv2;
        ImageView iv3;

        public ViewHolderText(@NonNull View itemView) {
            super(itemView);
            tv3 = itemView.findViewById(R.id.tv3);
            iv1 = itemView.findViewById(R.id.iv1);
            iv2 = itemView.findViewById(R.id.iv2);
            iv3 = itemView.findViewById(R.id.iv3);
        }
    }

    public class ViewHolderDesc extends RecyclerView.ViewHolder {
        ImageView iv4;

        public ViewHolderDesc(@NonNull View itemView) {

            super(itemView);
            iv4 = itemView.findViewById(R.id.iv4);
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
}
