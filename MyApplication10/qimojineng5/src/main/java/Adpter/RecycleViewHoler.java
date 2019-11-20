package Adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.qimojineng5.R;

import java.util.List;

import bean.Food;

public class RecycleViewHoler extends RecyclerView.Adapter {
    private List<Food.ResultsBean> list;
    private Context context;

    public RecycleViewHoler(List<Food.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.two, viewGroup, false);
        return new RecyclerViewHoler(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Food.ResultsBean resultsBean = list.get(i);
        Glide.with(context).load(resultsBean.getUrl()).into(((RecyclerViewHoler) viewHolder).iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecyclerViewHoler extends RecyclerView.ViewHolder {
        ImageView iv;

        public RecyclerViewHoler(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
