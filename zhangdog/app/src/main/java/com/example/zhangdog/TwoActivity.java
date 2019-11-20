package com.example.zhangdog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.zhangdog.adpter.RecycleViewAdpter;
import com.example.zhangdog.adpter.RecycleViewAdpter1;
import com.example.zhangdog.bean.Food;
import com.example.zhangdog.paesta.Peasta;
import com.example.zhangdog.view.HomeView;

import java.util.ArrayList;
import java.util.List;

public class TwoActivity extends AppCompatActivity implements HomeView {
    private List<Food.DataBean.DatasBean> arr;
    private RecycleViewAdpter1 recycleViewAdpter1;
    private View inflate;
    private CheckBox cb;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        inflate = LayoutInflater.from(TwoActivity.this).inflate(R.layout.three, null);
        cb = inflate.findViewById(R.id.cb);
        RecyclerView rv1 = findViewById(R.id.rv1);
        rv1.setLayoutManager(new LinearLayoutManager(TwoActivity.this));
        Peasta peasta = new Peasta(this);
        peasta.getData();
        arr = new ArrayList<>();
        recycleViewAdpter1 = new RecycleViewAdpter1(this, arr);
        rv1.setAdapter(recycleViewAdpter1);
        Button cao1 = findViewById(R.id.cao1);
        Button quan1 = findViewById(R.id.quan1);
        Button shan1 = findViewById(R.id.shan1);
        Button wan1 = findViewById(R.id.wan1);
        //监听全选的按钮
        quan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //全选
                cb.setChecked(true);
            }
        });
        recycleViewAdpter1.setOnLongClickListener(new RecycleViewAdpter1.OnLongClickListener() {
            @Override
            public void onLongClickListener(int i) {
                a = i;
            }
        });
        shan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb.isChecked()) {
                    arr.remove(a);
                    recycleViewAdpter1.notifyDataSetChanged();
                }
            }
        });
        wan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        arr.addAll(list);
        recycleViewAdpter1.notifyDataSetChanged();
}

    @Override
    public void getshibai(String shibai) {

    }
}
