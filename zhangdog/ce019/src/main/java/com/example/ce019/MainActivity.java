package com.example.ce019;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ce019.adpter.FragmentAdpter;
import com.example.ce019.fragment.Fragmenta;
import com.example.ce019.fragment.Fragmentb;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  //https://www.wanandroid.com/project/list/1/json?cid=294
        //http://cdn.banmi.com/banmiapp/apk/banmi330.apk
        ViewPager vp = findViewById(R.id.vp);
        TabLayout tl = findViewById(R.id.tl);
        Fragmenta fragmenta = new Fragmenta();
        Fragmentb fragmentb = new Fragmentb();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        arr.add(fragmentb);
        tl.setupWithViewPager(vp);
        FragmentAdpter fragmentAdpter = new FragmentAdpter(getSupportFragmentManager(),arr);
        vp.setAdapter(fragmentAdpter);
        tl.getTabAt(0).setText("首頁");
        tl.getTabAt(1).setText("我的");
    }
}
