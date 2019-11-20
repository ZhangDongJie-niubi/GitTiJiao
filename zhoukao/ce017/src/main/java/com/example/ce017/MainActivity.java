package com.example.ce017;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ce017.adpter.RecycleAdpter;
import com.example.ce017.bean.Food;
import com.example.ce017.presenter.Presenter;
import com.example.ce017.view.Homeview;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Homeview {

    private ArrayList<Food.BodyBean.ResultBean> arr;
    private RecycleAdpter recycleAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Presenter presenter = new Presenter(this);
        presenter.getData();
        arr = new ArrayList<>();;
        recycleAdpter = new RecycleAdpter(this, arr);
        rv.setAdapter(recycleAdpter);
        recycleAdpter.setOnLongClickListener(new RecycleAdpter.OnLongClickListener() {
            @Override
            public void onLongClickListener(int position) {
                Food.BodyBean.ResultBean resultBean = arr.get(position);
                Intent intent = new Intent(MainActivity.this,TwoActivity.class);
                String description = resultBean.getDescription();

                startActivity(intent);
            }
        });
    }
//https://api.yunxuekeji.cn/yunxue_app_api/teacher/getTeacherPower/ID
    @Override
    public void getchenggong(List<Food.BodyBean.ResultBean> list) {
        arr.addAll(list);
        recycleAdpter.notifyDataSetChanged();
    }

    @Override
    public void shibai(String shibai) {

    }
}