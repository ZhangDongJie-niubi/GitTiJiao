package com.example.qimojineng4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import adpter.RecycleAdpter;
import bean.Ban;
import bean.Rec;
import preasta.Preasta;
import view.Homeview;

public class MainActivity extends AppCompatActivity implements Homeview {

    private List<Rec.ResultsBean> arr;
    private List<Ban> arr1;
    private RecycleAdpter recycleAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arr = new ArrayList<>();
        arr1 = new ArrayList<>();
        recycleAdpter = new RecycleAdpter(arr, arr1, MainActivity.this);
        RecyclerView rv = findViewById(R.id.rv);
        Preasta preasta = new Preasta(this);
        preasta.getData();
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv.setAdapter(recycleAdpter);

    }

    @Override
    public void getchenggong(List<Rec.ResultsBean> list) {
        arr.addAll(list);
        recycleAdpter.notifyDataSetChanged();
    }

    @Override
    public void getchenggong1(List<Ban> ban) {
        arr1.addAll(ban);
        recycleAdpter.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {

    }
}
