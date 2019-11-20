package com.example.qimojineng5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import Adpter.RecycleViewHoler;
import Util.Util;
import bean.Food;
import bean.Foods;
import preasta.Preasta;
import view.Homeview;

public class MainActivity extends AppCompatActivity implements Homeview {

    @butterknife.BindView(R.id.tb)
    Toolbar tb;
    @butterknife.BindView(R.id.rv)
    RecyclerView rv;
    private List<Food.ResultsBean> arr;
    private RecycleViewHoler recycleViewHoler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);


        tb.setTitle("美女福利");
        setSupportActionBar(tb);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "线性布局");
        menu.add(1, 2, 1, "网格布局");
        menu.add(1, 3, 1, "瀑布布局");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                arr = new ArrayList<>();
                Preasta preasta1 = new Preasta(this);
                preasta1.getData();
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recycleViewHoler = new RecycleViewHoler(arr, MainActivity.this);
                rv.setAdapter(recycleViewHoler);
                Foods foods = new Foods();
                foods.setUrl(arr.toString());
                Util.util().insert(foods);
                break;
            case 2:
                arr = new ArrayList<>();
                Preasta preasta = new Preasta(this);
                preasta.getData();
                rv.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                recycleViewHoler = new RecycleViewHoler(arr, MainActivity.this);
                rv.setAdapter(recycleViewHoler);
                break;
            case 3:
                arr = new ArrayList<>();
                Preasta preasta2 = new Preasta(this);
                preasta2.getData();
                rv.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                recycleViewHoler = new RecycleViewHoler(arr, MainActivity.this);
                rv.setAdapter(recycleViewHoler);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getchenggong(List<Food.ResultsBean> list) {
        arr.addAll(list);
        recycleViewHoler.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {

    }
}
