package com.example.qimojineng4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import com.example.mvpchouqu.adpter.Recycleadpter;
import bean.Ban;
import bean.Rec;
import paesta.Paesta;
import view.Homeview;

public class MainActivity extends AppCompatActivity implements Homeview {

    private List<Rec.ResultsBean> arr;
    private List<Ban> arr1;
    private Recycleadpter recycleadpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Paesta paesta1 = new Paesta(this);
        paesta1.getData();


        RecyclerView rv = findViewById(R.id.rv);
        arr = new ArrayList<>();
        arr1 = new ArrayList<>();
        Paesta paesta = new Paesta(this);
        paesta.getData();
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recycleadpter = new Recycleadpter(arr, arr1, MainActivity.this);
        rv.setAdapter(recycleadpter);
    }

    @Override
    public void getchenggong(List<Rec.ResultsBean> list) {
        arr.addAll(list);
        recycleadpter.notifyDataSetChanged();
    }

    @Override
    public void getchenggong1(List<Ban> list1) {
        arr1.addAll(list1);
        recycleadpter.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {

    }
}
