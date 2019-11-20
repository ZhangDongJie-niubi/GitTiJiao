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
import com.example.ce013.R;

import java.util.List;

import bean.Food;

public class RecycleAdpter extends RecyclerView.Adapter {
    private List<Food.DataBean.DatasBean> list;
    private Context context;

    public List<Food.DataBean.DatasBean> getList() {
        return list;
    }

    public void setList(List<Food.DataBean.DatasBean> list) {
        this.list = list;
    }

    public RecycleAdpter(List<Food.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private int M = 0;
    private int MM = 1;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        if (position == M) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.two, null);
            return new RecycleViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.three, null);
            return new RecycleViewHolder1(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Food.DataBean.DatasBean datasBean = list.get(position);
        if (getItemViewType(position) == M) {
            ((RecycleViewHolder) holder).tv.setText(datasBean.getChapterName());
            ((RecycleViewHolder) holder).tv1.setText(datasBean.getNiceShareDate());
            ((RecycleViewHolder) holder).tv2.setText(datasBean.getTitle());
        } else {
            ((RecycleViewHolder1) holder).tv3.setText(datasBean.getChapterName());
            ((RecycleViewHolder1) holder).tv4.setText(datasBean.getNiceShareDate());
            ((RecycleViewHolder1) holder).tv5.setText(datasBean.getTitle());
            Glide.with(context).load(datasBean.getEnvelopePic()).into(((RecycleViewHolder1) holder).iv);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClickListener(position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClickListener(position);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return M;
        } else {
            return MM;
        }
    }

    class RecycleViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView tv1;
        TextView tv2;

        //98312238
        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }


    class RecycleViewHolder1 extends RecyclerView.ViewHolder {
        TextView tv3;
        TextView tv4;
        TextView tv5;
        ImageView iv;

        public RecycleViewHolder1(@NonNull View itemView) {
            super(itemView);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tv4);
            tv5 = itemView.findViewById(R.id.tv5);
            iv = itemView.findViewById(R.id.iv);
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
