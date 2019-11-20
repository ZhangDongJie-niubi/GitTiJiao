package com.example.erjitiaomu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Shi extends BaseExpandableListAdapter {
private Context context;
private ArrayList<String> teacher;
private ArrayList<ArrayList<String>> student;

    public Shi(Context context, ArrayList<String> teacher, ArrayList<ArrayList<String>> student) {
        this.context = context;
        this.teacher = teacher;
        this.student = student;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<String> getTeacher() {
        return teacher;
    }

    public void setTeacher(ArrayList<String> teacher) {
        this.teacher = teacher;
    }

    public ArrayList<ArrayList<String>> getStudent() {
        return student;
    }

    public void setStudent(ArrayList<ArrayList<String>> student) {
        this.student = student;
    }



    @Override
    public int getGroupCount() {
        return teacher.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return student.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return teacher.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return student.get(groupPosition).get(childPosition);
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
        tv.setText(teacher.get(groupPosition));

        return tv;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.two, null);
        TextView tv = inflate.findViewById(R.id.tv);
        tv.setText(student.get(groupPosition).get(childPosition));

        return tv;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
