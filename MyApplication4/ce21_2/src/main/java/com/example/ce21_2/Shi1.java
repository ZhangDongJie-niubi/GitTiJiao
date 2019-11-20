package com.example.ce21_2;

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
    private int M=0;
    private int MM=1;
    private int MMM=2;
    private List<Food.DataBean> list=new ArrayList<>();
    private Context context;

    public Shi1(Context context) {
        this.context = context;
    }


    public void initData(List<Food.DataBean> list){
        this.list.clear();
        this.list=list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%3==0){
            return M;
        }else if (position%3==1){
             return MM;
        }else{
          return MMM;
        }

}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==M){
            View inflate = LayoutInflater.from(context).inflate(R.layout.three, viewGroup, false);
            return new ViewHolder(inflate);
        }else if (i==MM){
            View inflate = LayoutInflater.from(context).inflate(R.layout.fore, viewGroup, false);
            return new ViewHolder1(inflate);
        }else{
            View inflate = LayoutInflater.from(context).inflate(R.layout.five, viewGroup, false);
            return new ViewHolder2(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        Food.DataBean dataBean = list.get(i);
        if (getItemViewType(i)==M){
            ((ViewHolder)viewHolder).tv1.setText(dataBean.getTitle());
            ((ViewHolder)viewHolder).tv2.setText(dataBean.getFood_str());
            Glide.with(context).load(dataBean.getPic()).into(((ViewHolder)viewHolder).iv1);
        }else if (getItemViewType(i)==MM){
            ((ViewHolder1)viewHolder).tv3.setText(dataBean.getTitle());
            Glide.with(context).load(dataBean.getPic()).into(((ViewHolder1)viewHolder).iv2);
            Glide.with(context).load(dataBean.getPic()).into(((ViewHolder1)viewHolder).iv3);
            Glide.with(context).load(dataBean.getPic()).into(((ViewHolder1)viewHolder).iv4);
        }else{
            Glide.with(context).load(dataBean.getPic()).into(((ViewHolder2)viewHolder).iv5);
        }
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
        ImageView iv1;
        TextView tv1;
        TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             iv1 = itemView.findViewById(R.id.iv1);
             tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
    public class ViewHolder1 extends RecyclerView.ViewHolder {

        TextView tv3;
        ImageView iv2;
        ImageView iv3;
        ImageView iv4;
        public ViewHolder1(@NonNull View itemView) {

            super(itemView);
            tv3 = itemView.findViewById(R.id.tv3);
            iv2 = itemView.findViewById(R.id.iv2);
            iv3 = itemView.findViewById(R.id.iv3);
            iv4 = itemView.findViewById(R.id.iv4);
        }
    }
    public class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView iv5;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            iv5 = itemView.findViewById(R.id.iv5);
        }
    }

    OnClickListener onClickListener;
    OnLongClickListener onLongClickListener;



    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
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
