package com.example.ce18;

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

public class Shi extends RecyclerView.Adapter {
    private int M = 0;
    private int MM = 1;
    private int MMM = 2;
    private List<String> list = new ArrayList<>();
    private Context context;

    public Shi(Context context) {
        this.context = context;
    }


    public void add(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
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

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == M) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.two, viewGroup, false);
            return new ViewHolder(inflate);
        } else if (i == MM) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.three, viewGroup, false);
            return new ViewHolder1(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.fore, viewGroup, false);
            return new ViewHolder2(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        String s = list.get(i);
        if (getItemViewType(i) == M) {
            ((ViewHolder) viewHolder).tv.setText(s);
            ((ViewHolder) viewHolder).tv1.setText(s);
            String string = "http://www.qubaobei.com/ios/cf/uploadfile/132/31/30630.jpg";
            Glide.with(context).load(string).into(((ViewHolder) viewHolder).iv);
        } else if (getItemViewType(i) == MM) {
            ((ViewHolder1) viewHolder).tv2.setText(s);
            String string = "http://www.qubaobei.com/ios/cf/uploadfile/132/31/30630.jpg";
            Glide.with(context).load(string).into(((ViewHolder1) viewHolder).iv1);
            Glide.with(context).load(string).into(((ViewHolder1) viewHolder).iv2);
            Glide.with(context).load(string).into(((ViewHolder1) viewHolder).iv3);
        } else {
            String string = "http://www.qubaobei.com/ios/cf/uploadfile/132/31/30630.jpg";
            Glide.with(context).load(string).into(((ViewHolder2) viewHolder).iv4);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickListener!=null){
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
        TextView tv1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
            iv = itemView.findViewById(R.id.iv);
        }
    }


    public class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView tv2;
        ImageView iv3;
        ImageView iv2;
        ImageView iv1;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            tv2 = itemView.findViewById(R.id.tv2);
            iv3 = itemView.findViewById(R.id.iv3);
            iv2 = itemView.findViewById(R.id.iv2);
            iv1 = itemView.findViewById(R.id.iv1);
        }
    }


    public class ViewHolder2 extends RecyclerView.ViewHolder {
        ImageView iv4;

        public ViewHolder2(@NonNull View itemView) {
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
