package com.example.lianxi2;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //    获取tab标签接口：https://www.wanandroid.com/project/tree/json
        //    各个tab下的列表接口：https://www.wanandroid.com/project/list/1/json?cid=312
        ViewPager vp = findViewById(R.id.vp);
        TabLayout tl = findViewById(R.id.tl);
        Fragmenta fragmenta = new Fragmenta();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        Shi1 shi3 = new Shi1(getSupportFragmentManager(),arr);
        vp.setAdapter(shi3);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("項目").setIcon(R.drawable.ic_launcher_background);
    }
}
