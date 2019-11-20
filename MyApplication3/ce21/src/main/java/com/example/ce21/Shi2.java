package com.example.ce21;

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

public class Shi2 extends RecyclerView.Adapter<Shi2.ViewHolder> {
    private List<Food.DataBean> list=new ArrayList<>();
    private Context context;

    public void initData(List<Food.DataBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public Shi2(Context context) {
        this.context = context;
    }

//    public Shi2(List<Food.DataBean> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }


    @NonNull
    @Override
    public Shi2.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.three, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Food.DataBean dataBean = list.get(i);
        viewHolder.te.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getPic()).into(viewHolder.im);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView im;
        TextView te;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            im = itemView.findViewById(R.id.im);
             te = itemView.findViewById(R.id.te);
        }
    }
}
