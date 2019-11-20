package com.example.qimojinenge;

import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import Adpter.FragmentAdpter;
import Fragment.Fragmenta;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tl = findViewById(R.id.tl);
        ViewPager vp = findViewById(R.id.vp);

        Fragmenta fragmenta = new Fragmenta();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        FragmentAdpter adpter = new FragmentAdpter(getSupportFragmentManager(), arr);
        vp.setAdapter(adpter);

        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("类型一");

    }
}
