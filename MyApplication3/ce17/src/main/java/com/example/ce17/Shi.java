package com.example.ce17;

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
    private Context context;
    private ArrayList<Food.DataBean> list = new ArrayList<>();


    public Shi(Context context) {
        this.context = context;
    }

    public ArrayList<Food.DataBean> getList() {
        return list;
    }

    public void setList(ArrayList<Food.DataBean> list) {
        this.list = list;
    }

    public void add(List<Food.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void remove(int i) {
        this.list.remove(i);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.three, viewGroup, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Food.DataBean dataBean = list.get(i);
        viewHolder.viewById1.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getPic()).into(viewHolder.viewById);



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onItemClick(i);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onClickLongListener!=null) {
                    onClickLongListener.OnClickLongListener(i);
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


        ImageView viewById;
        TextView viewById1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            viewById = itemView.findViewById(R.id.image);
            viewById1 = itemView.findViewById(R.id.tvee);

        }
    }

    OnClickListener onClickListener;
    OnClickLongListener onClickLongListener;

    public void setOnClickLongListener(OnClickLongListener onClickLongListener) {
        this.onClickLongListener = onClickLongListener;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {

        void onItemClick(int i);
    }

    public interface OnClickLongListener {
        void OnClickLongListener(int i);
    }
}
