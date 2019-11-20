package com.example.qimojinengaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adpter.Fragmentadpter;
import fragment.Fragmentb;
import fragment.Fragmenta;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.vp);
        TabLayout tl = findViewById(R.id.tl);
        List<Fragment> arr = new ArrayList<>();
        Fragmenta fragmenta = new Fragmenta();
        Fragmentb fragmentb = new Fragmentb();
        arr.add(fragmenta);
        arr.add(fragmentb);
        Fragmentadpter fragmentadpter = new Fragmentadpter(getSupportFragmentManager(), arr);
        vp.setAdapter(fragmentadpter);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("首页");
        tl.getTabAt(1).setText("下载");


    }
}
