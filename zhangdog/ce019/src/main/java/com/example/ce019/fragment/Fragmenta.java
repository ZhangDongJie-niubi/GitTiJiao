package com.example.ce019.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ce019.R;
import com.example.ce019.TwoActivity;
import com.example.ce019.adpter.RecyclerAdpter;
import com.example.ce019.bean.Food;
import com.example.ce019.model.Asd;
import com.example.ce019.peasener.Peasener;
import com.example.ce019.view.Homeview;

import java.util.ArrayList;
import java.util.List;

public class Fragmenta extends Fragment implements Homeview {

    private List<Food.DataBean.DatasBean> arr;
    private RecyclerAdpter recyclerAdpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.two, null);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        RecyclerView rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        arr = new ArrayList<>();
        recyclerAdpter = new RecyclerAdpter(arr, getContext());
        Peasener peasener = new Peasener(this);
        peasener.getData();
        rv.setAdapter(recyclerAdpter);
        recyclerAdpter.setOnClickListener(new RecyclerAdpter.OnClickListener() {
            @Override
            public void onClickListener(int i) {
                Intent intent = new Intent(getContext(), TwoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        arr.addAll(list);
        recyclerAdpter.notifyDataSetChanged();
    }
}
