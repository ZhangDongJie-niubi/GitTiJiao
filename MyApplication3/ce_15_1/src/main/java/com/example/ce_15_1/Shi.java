package com.example.ce_15_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Shi extends BaseAdapter {
    private Context context;
    private List<Food.DataBean> list;


    public Shi(Context context, List<Food.DataBean> list) {
        this.context = context;
        this.list = list;
    }



    public void shan(int position){
      this.list.remove(position);
       notifyDataSetChanged();
    }
    public void setList(List<Food.DataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.two, null);
            viewHolder.ivv = convertView.findViewById(R.id.ivv);
            viewHolder.tvv = convertView.findViewById(R.id.tvv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Food.DataBean dataBean = list.get(position);
        viewHolder.tvv.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getPic()).into(viewHolder.ivv);

        return convertView;
    }
    class ViewHolder{
      ImageView ivv;
      TextView tvv;
    }
}
