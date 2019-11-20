package com.example.day7;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.*;

public class Shi extends RecyclerView.Adapter<Shi.ViewHolder> {
    Context context;
    List<String> list = new ArrayList<>();

    public Shi(Context context) {
        this.context = context;
    }

    public void add(List<String> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void remove(int i) {
        this.list.remove(i);
        notifyDataSetChanged();
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }






    @NonNull
    @Override
    public Shi.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.two, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Shi.ViewHolder viewHolder, final int i) {
        String title = list.get(i);

        viewHolder.tv.setText(title);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onItemClick(i);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onItemLongClick(i);
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
        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }


    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    interface OnClickListener {
        void onItemClick(int i);

        void onItemLongClick(int i);
    }
}
