package com.example.ce005;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import com.example.mvpchouqu.adpter.Fragmentadpter;
import com.example.mvpchouqu.fragment.Fragmenta;
import com.example.mvpchouqu.fragment.Fragmentb;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.vp);
        TabLayout tl = findViewById(R.id.tl);

        Fragmenta fragmenta = new Fragmenta();
        Fragmentb fragmentb = new Fragmentb();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        arr.add(fragmentb);
        Fragmentadpter fragmentadpter = new Fragmentadpter(getSupportFragmentManager(), arr);

        vp.setAdapter(fragmentadpter);

        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("我的");
        tl.getTabAt(1).setText("收藏");

    }
}
