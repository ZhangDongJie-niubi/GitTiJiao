package com.example.zongheti3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Shi3 extends BaseExpandableListAdapter {
    private List<Er.DataBean>list=new ArrayList<>();
    private Context context;

    public Shi3(Context context) {
        this.context = context;
    }
    public void jjj(List<Er.DataBean>list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getChildren().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getChildren().get(childPosition);
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
        TextView tv = new TextView(context);
        tv.setTextSize(20);
        Er.DataBean dataBean = list.get(groupPosition);
        tv.setText(dataBean.getName());
        return tv;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        Er.DataBean.ChildrenBean childrenBean = list.get(groupPosition).getChildren().get(childPosition);
        tv.setText(childrenBean.getName());
        return tv;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
