package com.example.mvpchouqu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qimojinengd.R;
import com.example.qimojinengd.dao.Util;

import java.util.List;

import com.example.mvpchouqu.adpter.Recycleapterb;
import bean.Daobean;

public class Fragmentb extends Fragment {
    private int a;
    private List<Daobean> cha;
    private TextView tv2;
    private ImageView iv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.seven, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        RecyclerView rv1 = inflate.findViewById(R.id.rv1);
        rv1.setLayoutManager(new LinearLayoutManager(getContext()));
        cha = Util.getUtil().cha();
        Recycleapterb recycleapterb = new Recycleapterb(cha, getContext());

        rv1.setAdapter(recycleapterb);

    }
}
