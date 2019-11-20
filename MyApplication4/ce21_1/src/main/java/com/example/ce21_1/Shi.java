package com.example.ce21_1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Shi extends BaseAdapter {
private List<String> list=new ArrayList<>();
private Context context;
    private TextView viewById;

    public Shi(Context context) {
        this.context = context;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
   public void add(List<String> list){
        this.list=list;
        notifyDataSetChanged();

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
    public View getView(int position, View convertView, ViewGroup parent) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.two, null);
        viewById = inflate.findViewById(R.id.tv);
        ImageView viewById = inflate.findViewById(R.id.ivv);
        String s = list.get(position);
        this.viewById.setText(s);
        String string="http://www.qubaobei.com/ios/cf/uploadfile/132/9/8289.jpg";
        Glide.with(context).load(string).into(viewById);
        return inflate;
    }


}
