package com.example.zongheti3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Shi4 extends BaseAdapter {
  private   List<Phone> arr;
  private Context context;

    public Shi4(List<Phone> arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.shier, null);
        TextView aa = convertView.findViewById(R.id.text5);
        TextView bb = convertView.findViewById(R.id.text6);
        Phone phone = arr.get(position);
        aa.setText(phone.getName());
        bb.setText(phone.getPhone());
        return convertView;
    }
}
