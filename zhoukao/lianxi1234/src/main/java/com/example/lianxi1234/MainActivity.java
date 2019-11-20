package com.example.lianxi1234;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.vp);
        TabLayout tl = findViewById(R.id.tl);
        Fragmenta fragmenta = new Fragmenta();
        Fragmentb fragmentb = new Fragmentb();

        List<Fragment> list = new ArrayList<>();
        list.add(fragmenta);
        list.add(fragmentb);
        Fragmentadpter fragmentadpter = new Fragmentadpter(getSupportFragmentManager(), list);
        vp.setAdapter(fragmentadpter);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("首页");
        tl.getTabAt(1).setText("收藏");

    }
}
