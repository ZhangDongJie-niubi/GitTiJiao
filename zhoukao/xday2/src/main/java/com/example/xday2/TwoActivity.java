package com.example.xday2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import com.example.mvpchouqu.adpter.RecycleAdpter1;
import com.example.mvpchouqu.adpter.RecycleAdpter2;
import bean.Food;
import paesta.Peasta;
import view.Homeview;

public class TwoActivity extends AppCompatActivity implements Homeview {

    private List<Food.DataBean> arr;
    private RecycleAdpter2 recycleAdpter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Peasta peasta = new Peasta(this);
        peasta.getData();

        RecyclerView rv2 = findViewById(R.id.rv2);
        rv2.setLayoutManager(new LinearLayoutManager(TwoActivity.this));
        arr = new ArrayList<>();
        recycleAdpter2 = new RecycleAdpter2(arr, TwoActivity.this);
        rv2.setAdapter(recycleAdpter2);
        recycleAdpter2.setOnClickListener(new RecycleAdpter1.OnClickListener() {
            @Override
            public void onClickListener(int position) {
                Intent intent = new Intent(TwoActivity.this, ThreeActivity.class);
                Food.DataBean dataBean = arr.get(position);
                String pic = dataBean.getPic();
                String title = dataBean.getTitle();
                intent.putExtra("pic", pic);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getchenggong(List<Food.DataBean> list) {
        arr.addAll(list);
        recycleAdpter2.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {

    }
}
