package com.example.xday2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import com.example.mvpchouqu.adpter.RecycleAdpter;
import com.example.mvpchouqu.adpter.RecycleAdpter1;
import bean.Food;
import paesta.Peasta;
import view.Homeview;

public class MainActivity extends AppCompatActivity implements Homeview {

    private List<Food.DataBean> arr;
    private RecycleAdpter recycleAdpter;
    private List<Food.DataBean> arr1;
    private RecycleAdpter1 recycleAdpter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Peasta peasta = new Peasta(this);
        peasta.getData();


        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        arr1 = new ArrayList<>();
        recycleAdpter1 = new RecycleAdpter1(arr1, MainActivity.this);
        rv.setAdapter(recycleAdpter1);
        recycleAdpter1.setOnClickListener(new RecycleAdpter1.OnClickListener() {
            @Override
            public void onClickListener(int position) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });


        RecyclerView rv1 = findViewById(R.id.rv1);
        rv1.addItemDecoration(new DividerItemDecoration(MainActivity.this, 1));
        rv1.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        arr = new ArrayList<>();
        recycleAdpter = new RecycleAdpter(arr, MainActivity.this);
        rv1.setAdapter(recycleAdpter);


    }

    @Override
    public void getchenggong(List<Food.DataBean> list) {
        arr.addAll(list);
        recycleAdpter.notifyDataSetChanged();
        arr1.addAll(list);
        recycleAdpter1.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {

    }
}
