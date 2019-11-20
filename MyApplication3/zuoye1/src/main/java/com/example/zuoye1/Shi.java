package com.example.zuoye1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Shi extends BaseExpandableListAdapter {
private Context context;
private ArrayList<String> sheng;
private ArrayList<ArrayList<String>> shi;

    public Shi(Context context, ArrayList<String> sheng, ArrayList<ArrayList<String>> shi) {
        this.context = context;
        this.sheng = sheng;
        this.shi = shi;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<String> getSheng() {
        return sheng;
    }

    public void setSheng(ArrayList<String> sheng) {
        this.sheng = sheng;
    }

    public ArrayList<ArrayList<String>> getShi() {
        return shi;
    }

    public void setShi(ArrayList<ArrayList<String>> shi) {
        this.shi = shi;
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.two, null);
        TextView tv = inflate.findViewById(R.id.tv);
        tv.setText(shi.get(groupPosition).get(childPosition));
        return tv;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
