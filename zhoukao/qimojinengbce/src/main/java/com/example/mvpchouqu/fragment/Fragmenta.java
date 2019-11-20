package com.example.mvpchouqu.fragment;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qimojinengbce.Jieshou;
import com.example.qimojinengbce.R;

import java.util.ArrayList;
import java.util.List;

import com.example.mvpchouqu.adpter.Recycleapter;
import bean.Food;
import peasta.Peasta;
import view.Homeview;

public class Fragmenta extends Fragment implements Homeview {

    private List<Food.DataBean.DatasBean> arr;
    private Recycleapter recycleapter;
    private Jieshou jieshou;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.two, container, false);
        initView(inflate);
        return inflate;
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("asd");
        jieshou = new Jieshou();
        getActivity().registerReceiver(jieshou, intentFilter);
    }

    private void initView(final View inflate) {
        arr = new ArrayList<>();
        recycleapter = new Recycleapter(arr, getContext());
        RecyclerView rv = inflate.findViewById(R.id.rv);
        Peasta peasta = new Peasta(this);
        peasta.getData();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(recycleapter);
        recycleapter.setOnClickListener(new Recycleapter.OnClickListener() {
            @Override
            public void onClickListener(int position) {
                Intent intent = new Intent("asd");
                Food.DataBean.DatasBean datasBean = arr.get(position);
                String title = datasBean.getTitle();
                intent.putExtra("title", title);
                getActivity().sendBroadcast(intent);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(jieshou);
    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        arr.addAll(list);
        recycleapter.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {

    }
}
