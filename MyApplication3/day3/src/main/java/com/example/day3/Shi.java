package com.example.day3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Shi extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<ArrayList<String>> shi;
    private ArrayList<String> sheng;

    public Shi(Context context, ArrayList<ArrayList<String>> shi, ArrayList<String> sheng) {
        this.context = context;
        this.shi = shi;
        this.sheng = sheng;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<ArrayList<String>> getShi() {
        return shi;
    }

    public void setShi(ArrayList<ArrayList<String>> shi) {
        this.shi = shi;
    }

    public ArrayList<String> getSheng() {
        return sheng;
    }

    public void setSheng(ArrayList<String> sheng) {
        this.sheng = sheng;
    }

    @Override
    public int getGroupCount() {
        return sheng.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return shi.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return sheng.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return shi.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.two, null);

        TextView tv = inflate.findViewById(R.id.tv);
        tv.setText(sheng.get(groupPosition));
        return tv;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.three, null);
        TextView tv = inflate.findViewById(R.id.tv1);
        tv.setText(shi.get(groupPosition).get(childPosition));
        return tv;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
