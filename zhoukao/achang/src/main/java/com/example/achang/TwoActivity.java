package com.example.achang;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adpter.RecycleAdpter;
import bean.Food;
import peaster.Peaster;
import view.HomeView;

public class TwoActivity extends AppCompatActivity implements HomeView {

    private RecycleAdpter recycleAdpter;
    private List<Food.DataBean.ListBean> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        TextView tv = findViewById(R.id.tv);
        tv.setText("账户余额:" + text);

        Toolbar tb = findViewById(R.id.tb);
        tb.setTitle("                              兑换");

        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(TwoActivity.this));
        arr = new ArrayList<>();
        recycleAdpter = new RecycleAdpter(TwoActivity.this, arr);
        Peaster peaster = new Peaster(this);
        peaster.getData();
        rv.setAdapter(recycleAdpter);
        recycleAdpter.setOnClickListener(new RecycleAdpter.OnClickListener() {
            @Override
            public void onClickListener(int position) {

            }
        });
    }

    @Override
    public void getchenggong(List<Food.DataBean.ListBean> list) {
        arr.addAll(list);
        recycleAdpter.notifyDataSetChanged();
    }
}
