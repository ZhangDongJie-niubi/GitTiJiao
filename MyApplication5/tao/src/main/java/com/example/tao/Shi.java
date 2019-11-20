package com.example.tao;

        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

public class Shi extends RecyclerView.Adapter {
    private List<Zong.DataBean> dataBeans=new ArrayList<>();
    private Context context;

    public Shi(Context context) {
        this.context = context;
    }
    public void add(List<Zong.DataBean> dataBeans){
        this.dataBeans.addAll(dataBeans);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fore, null);
        return new RecycleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Zong.DataBean dataBean = dataBeans.get(i);
        ((RecycleViewHolder)viewHolder).tv.setText(dataBean.getName());
        ((RecycleViewHolder)viewHolder).tv1.setText(dataBean.getId());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        TextView tv1;
        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }
}
