package adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.achang.R;

import java.util.List;

import bean.Food;

public class RecycleAdpter extends RecyclerView.Adapter {
    private Context context;
    private List<Food.DataBean.ListBean> list;

    public RecycleAdpter(Context context, List<Food.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.three, null);
        return new RecycleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Food.DataBean.ListBean listBean = list.get(position);
        Glide.with(context).load(listBean.getPic()).into(((RecycleViewHolder) holder).iv);
        ((RecycleViewHolder) holder).tv1.setText(listBean.getName());
        ((RecycleViewHolder) holder).tv2.setText(listBean.getPrice() + "元");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1;
        TextView tv2;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
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
        void onClickListener(int position);
    }

   public interface OnLongClickListener {
        void onLongClickListener(int position);
    }

}
