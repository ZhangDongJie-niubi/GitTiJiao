package com.example.mvpchouqu.fragment;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qimojinengd.R;
import com.example.qimojinengd.dao.Util;

import java.util.ArrayList;
import java.util.List;

import com.example.mvpchouqu.adpter.Recycleapter;
import bean.Daobean;
import bean.Food;
import paesta.Paesta;
import view.Homeview;

public class Fragmenta extends Fragment implements Homeview {
private int a;
    private List<Food.DataBean.DatasBean> arr;
    private Recycleapter recycleapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.five, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        RecyclerView rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        registerForContextMenu(rv);
        arr = new ArrayList<>();
        Paesta paesta = new Paesta(this);
        paesta.getdata();
        rv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recycleapter = new Recycleapter(arr, getContext());
        rv.setAdapter(recycleapter);

        recycleapter.setOnLongClickListener(new Recycleapter.OnLongClickListener() {
            @Override
            public void onLongClickListener(final int position) {
                a=position;
                Food.DataBean.DatasBean datasBean = arr.get(position);
                String desc = datasBean.getDesc();
                String envelopePic = datasBean.getEnvelopePic();
                Daobean daobean = new Daobean();
                daobean.setDesc(desc);
                daobean.setEnvelopePic(envelopePic);
                Util.getUtil().insert(daobean);
                Toast.makeText(getContext(), "添加成功", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        arr.addAll(list);
        recycleapter.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {

    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(1, 1, 1, "刪除");
        menu.add(1, 2, 1, "修改");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1:
                arr.remove(a);
                recycleapter.notifyDataSetChanged();
                break;
            case 2:

                break;
        }
        return super.onContextItemSelected(item);
    }
}
