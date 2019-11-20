package com.example.qimojinengdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

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
        tl.getTabAt(0).setText("首頁");
        tl.getTabAt(1).setText("收藏");


    }
}
