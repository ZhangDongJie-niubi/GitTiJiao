package com.example.mvpchouqu.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ce005.R;
import com.example.jiehe.dao.Util;

import java.util.ArrayList;
import java.util.List;

import com.example.mvpchouqu.adpter.Recycleadpter;
import bean.Food;
import bean.Foods;
import pasta.Pasta;
import view.Homeview;

public class Fragmenta extends Fragment implements Homeview {

    private List<Food.RecentBean> arr;
    private Recycleadpter recycleadpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.two, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        RecyclerView rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        Pasta pasta = new Pasta(this);
        pasta.getData();
        arr = new ArrayList<>();
        recycleadpter = new Recycleadpter(arr, getContext());
        rv.setAdapter(recycleadpter);

        recycleadpter.setOnLongClickListener(new Recycleadpter.OnLongClickListener() {
            @Override
            public void onLongClickListener(final int position) {
                View inflate1 = LayoutInflater.from(getContext()).inflate(R.layout.fore, null);
                Button queren = inflate1.findViewById(R.id.queren);
                Button quxiao = inflate1.findViewById(R.id.quxiao);
                LinearLayout ll = inflate1.findViewById(R.id.ll);
                final PopupWindow popupWindow = new PopupWindow(inflate1, ViewGroup.LayoutParams.MATCH_PARENT, 500);
                popupWindow.showAtLocation(ll, Gravity.CENTER, 0, 0);
                queren.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Food.RecentBean recentBean = arr.get(position);
                        String url = recentBean.getUrl();
                        String title = recentBean.getTitle();
                        Foods foods = new Foods();
                        foods.setUrl(url);
                        foods.setTitle(title);
                        Util.util().insert(foods);
                        popupWindow.dismiss();
                    }
                });
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void getchenggong(List<Food.RecentBean> list) {
        arr.addAll(list);
        recycleadpter.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {

    }
}
