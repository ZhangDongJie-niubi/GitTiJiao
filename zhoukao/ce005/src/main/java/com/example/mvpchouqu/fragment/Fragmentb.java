package com.example.mvpchouqu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ce005.R;
import com.example.jiehe.dao.Util;

import java.util.List;

import com.example.mvpchouqu.adpter.Recycleradpter;
import bean.Foods;

public class Fragmentb extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.five, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        RecyclerView rv = inflate.findViewById(R.id.rv1);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Foods> cha = Util.util().cha();
        Recycleradpter recycleadpter = new Recycleradpter(cha, getContext());
        rv.setAdapter(recycleadpter);
    }
}
