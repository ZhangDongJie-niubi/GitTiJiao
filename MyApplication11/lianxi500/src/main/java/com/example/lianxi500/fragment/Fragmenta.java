package com.example.lianxi500.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lianxi500.R;
import com.example.lianxi500.adpter.RecyclerAdpter;
import com.example.lianxi500.bean.Food;
import com.example.lianxi500.modle.Asd;
import com.example.lianxi500.peater.Peater;
import com.example.lianxi500.view.Homeview;

import java.util.ArrayList;
import java.util.List;

public class Fragmenta extends Fragment implements Homeview {

    private List<Food.DataBean.DatasBean> arr;
    private RecyclerAdpter recyclerAdpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.two, null);
        getData(inflate);
        return inflate;
    }

    private void getData(View inflate) {
        RecyclerView rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        Peater peater = new Peater(this);
        peater.getData();
        arr = new ArrayList<>();
        recyclerAdpter = new RecyclerAdpter(getContext(), arr);
        rv.setAdapter(recyclerAdpter);

    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        arr.addAll(list);
        recyclerAdpter.notifyDataSetChanged();
    }
}
