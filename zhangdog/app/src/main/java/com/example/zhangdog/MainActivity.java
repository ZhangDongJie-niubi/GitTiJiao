package com.example.zhangdog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.zhangdog.adpter.RecycleViewAdpter;
import com.example.zhangdog.bean.Food;
import com.example.zhangdog.paesta.Peasta;
import com.example.zhangdog.view.HomeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeView {

    private List<Food.DataBean.DatasBean> arr;
    private RecycleViewAdpter recycleViewAdpter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //调用空间RecycleView
        RecyclerView rv = findViewById(R.id.rv);
        //绑定RecycleView
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //调用P层的方法
        Peasta peasta = new Peasta(this);
        peasta.getData();
        //创建一个空的集合
        arr = new ArrayList<>();
        //创建适配器
        recycleViewAdpter = new RecycleViewAdpter(this, arr);
        //适配
        rv.setAdapter(recycleViewAdpter);
//找到操作的按钮空间
        Button cao = findViewById(R.id.cao);
        //监听
        cao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        arr.addAll(list);
        recycleViewAdpter.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {

    }
}
