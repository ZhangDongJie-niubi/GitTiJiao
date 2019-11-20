package com.example.ce15;

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

public class Shi extends RecyclerView.Adapter<Shi.ViewHolder> {
    private List<Food.DataBean> list=new ArrayList<>();
    private Context context;

    public Shi(Context context) {
        this.context = context;
    }

    public List<Food.DataBean> getList() {
        return list;
    }

    public void setList(List<Food.DataBean> list) {
        this.list = list;
    }
    public void add(List<Food.DataBean> list){
        this.list=list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Shi.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.three, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Shi.ViewHolder viewHolder, final int i) {
        Food.DataBean dataBean = list.get(i);
        viewHolder.tv.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getPic()).into(viewHolder.iv);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener!=null){
                 onClickListener.onClickListener(i);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onLongClickListener!=null){
                      onLongClickListener.onLongClickListener(i);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv= itemView.findViewById(R.id.iv);
             tv = itemView.findViewById(R.id.tv);
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
