package com.example.day8_1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Shi shi;
    private ArrayList<String> arr;
    private SmartRefreshLayout sl;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        sl = findViewById(R.id.sl);
        arr = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
             arr.add("張東傑"+i);
        }
        shi = new Shi(this);
        shi.add(arr);

        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setAdapter(shi);

        sl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                shi.shua(arr);
                sl.finishRefresh(2000);
            }
        });
        sl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
           shi.jia(arr);
               sl.finishLoadMore(2000);
            }
        });
    }
}
