package Adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qimojinenge.R;

import java.util.List;

import bean.Food;

public class RecycleAdpter extends RecyclerView.Adapter {
    private List<Food.DataBean.DatasBean> list;
    private Context context;

    public RecycleAdpter(List<Food.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.two, null);
        return new RecycleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Food.DataBean.DatasBean datasBean = list.get(i);
        ((RecycleViewHolder) viewHolder).tv.setText(datasBean.getTitle());
        Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecycleViewHolder) viewHolder).iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
