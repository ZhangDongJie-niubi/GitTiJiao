package com.example.day72;

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

public class Shi extends RecyclerView.Adapter  {
    private int TEXTT = 0;
    private int IMAGE = 1;
    private Context context;
    private List<String> list = new ArrayList<>();

    public Shi(Context context) {
        this.context = context;
    }

    public List<String> getList() {
        return list;
    }


    public void setList(List<String> list) {

        this.list = list;
    }

    public void add(List<String> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == IMAGE) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.three, viewGroup, false);
            return new ViewHolder(inflate);
        }else{
            View inflate = LayoutInflater.from(context).inflate(R.layout.two, viewGroup, false);
            return new ViewHolderText(inflate);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position%2==0){
            return TEXTT;
        }else{
            return IMAGE;
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        String s = list.get(i);
        if (getItemViewType(i)==IMAGE){
            String imgUrl = "http://www.qubaobei.com/ios/cf/uploadfile/132/9/8289.jpg";

            Glide.with(context).load(imgUrl).into(((ViewHolder)viewHolder).iv);
        }else{
            ((ViewHolderText)viewHolder).tv.setText(s);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           iv = itemView.findViewById(R.id.iv);
        }
    }
    public class ViewHolderText extends RecyclerView.ViewHolder{
         TextView tv;
        public ViewHolderText(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }


}
