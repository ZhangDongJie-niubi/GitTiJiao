package com.example.ce013;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import adpter.RecycleAdpter;
import bean.Food;
import paesta.Peasta;
import view.HomeView;

public class MainActivity extends AppCompatActivity implements HomeView {

    private RecycleAdpter recycleAdpter;
    private List<Food.DataBean.DatasBean> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tb = findViewById(R.id.tb);
        tb.setTitle("                         文章列表");
        setSupportActionBar(tb);
        RecyclerView rv = findViewById(R.id.rv);
        rv.addItemDecoration(new DividerItemDecoration(MainActivity.this, 1));
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Peasta peasta = new Peasta(this);
        peasta.getData();
        arr = new ArrayList<>();
        recycleAdpter = new RecycleAdpter(arr, MainActivity.this);
        rv.setAdapter(recycleAdpter);
        recycleAdpter.setOnClickListener(new RecycleAdpter.OnClickListener() {
            @Override
            public void onClickListener(int position) {
                //Food.DataBean.DatasBean datasBean = arr.get(position);
               /* String chapterName = datasBean.getChapterName();
                String title = datasBean.getTitle();
                String niceShareDate = datasBean.getNiceShareDate();
                String envelopePic = datasBean.getEnvelopePic();*/

                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
             /*   intent.putExtra("chapterName", chapterName);
                intent.putExtra("title", title);
                intent.putExtra("niceShareDate", niceShareDate);
                intent.putExtra("envelopePic", envelopePic);*/

                List<Food.DataBean.DatasBean> list = recycleAdpter.getList();
                intent.putExtra("link",list.get(position).getLink());
                startActivity(intent);

            }
        });

    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        arr.addAll(list);
        recycleAdpter.notifyDataSetChanged();
    }

    @Override
    public void geishibai(String shibai) {

    }
}
