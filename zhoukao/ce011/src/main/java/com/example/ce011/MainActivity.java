package com.example.ce011;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ce011.adpter.RecyclerAdpter;
import com.example.ce011.bean.Food;
import com.example.ce011.peaste.Paesta;
import com.example.ce011.view.Homeview;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Homeview, View.OnClickListener {

    private List<Food.DataBean.DatasBean> arr;
    private RecyclerAdpter recyclerAdpter;
    private Button caozuo;
    private Button quanxuan;
    private Button shanchu;
    private Button wancheng;
    private List<Boolean> booleans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Paesta paesta = new Paesta(this);
        paesta.getData();
        arr = new ArrayList<>();
        booleans = new ArrayList<>();
        recyclerAdpter = new RecyclerAdpter(MainActivity.this, arr);
        rv.setAdapter(recyclerAdpter);
    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        arr.addAll(list);
        recyclerAdpter.notifyDataSetChanged();
    }

    @Override
    public void getshibai(String shibai) {

    }

    private void initView() {
        caozuo = (Button) findViewById(R.id.caozuo);
        quanxuan = (Button) findViewById(R.id.quanxuan);
        shanchu = (Button) findViewById(R.id.shanchu);
        wancheng = (Button) findViewById(R.id.wancheng);

        caozuo.setOnClickListener(this);
        quanxuan.setOnClickListener(this);
        shanchu.setOnClickListener(this);
        wancheng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.caozuo:
                cao();
                break;
            case R.id.quanxuan:
                quan();
                break;
            case R.id.shanchu:
                shan();
                break;
            case R.id.wancheng:
                wan();
                break;
        }
    }
    private void cao() {

    }
    private void quan() {

    }
    private void shan() {

    }
    private void wan() {

    }
}


//
//    <?xml version="1.0" encoding="utf-8"?>
//<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
//        android:layout_width="match_parent"
//        android:layout_height="50dp"
//        android:orientation="horizontal"
//        android:padding="10dp">
//
//<ImageView
//        android:id="@+id/item_iv"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_centerVertical="true"
//                android:scaleType="centerCrop"
//                android:src="@mipmap/ic_launcher"></ImageView>
//
//<TextView
//        android:id="@+id/item_tv"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_centerVertical="true"
//                android:layout_marginLeft="10dp"
//                android:layout_toRightOf="@+id/item_iv"
//                android:text="哈哈"></TextView>
//
//
//<CheckBox
//        android:id="@+id/item_cb"
//                android:layout_width="wrap_content"
//                android:layout_height="wrap_content"
//                android:layout_alignParentRight="true"
//                android:layout_centerVertical="true"
//                android:layout_marginLeft="10dp"
//                android:layout_marginRight="15dp"
//                android:visibility="gone"></CheckBox>
//
//
//</RelativeLayout>