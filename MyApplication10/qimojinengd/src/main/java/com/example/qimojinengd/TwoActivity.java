package com.example.qimojinengd;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Adpter.FragmentAdpter;
import Fragment.Fragmenta;
import Fragment.Fragmentb;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ViewPager vp = findViewById(R.id.vp);
        TabLayout tl = findViewById(R.id.tl);

        List<Fragment> arr = new ArrayList<>();
        Fragmenta fragmenta = new Fragmenta();
        Fragmentb fragmentb = new Fragmentb();
        arr.add(fragmenta);
        arr.add(fragmentb);
        FragmentAdpter fragmentAdpter = new FragmentAdpter(getSupportFragmentManager(), arr);
        vp.setAdapter(fragmentAdpter);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("首页");
        tl.getTabAt(1).setText("收藏");

    }
}
