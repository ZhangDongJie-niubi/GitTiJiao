package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ThreeActivity extends AppCompatActivity {

    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        DrawerLayout dl = findViewById(R.id.dl);
        Toolbar tb = findViewById(R.id.tb);
        ll = findViewById(R.id.ll);
        ViewPager vp1 = findViewById(R.id.vp1);
        TabLayout tl = findViewById(R.id.tl);
        NavigationView nv = findViewById(R.id.nv);


        ActionBarDrawerToggle abd = new ActionBarDrawerToggle(this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(abd);
        abd.syncState();


        View headerView = nv.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThreeActivity.this, ForeActivity.class);
                startActivity(intent);
            }
        });

        tb.setTitle("ToolBar标题");
        setSupportActionBar(tb);

        Fragmenta fragmenta = new Fragmenta();
//        Fragmentb fragmentb = new Fragmentb();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
//        arr.add(fragmentb);
        Shi2 shi2 = new Shi2(getSupportFragmentManager(), arr);
        vp1.setAdapter(shi2);
        tl.setupWithViewPager(vp1);
        tl.getTabAt(0).setText("首页");
//        tl.getTabAt(1).setText("收藏");


        dl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
                float v1 = view.getWidth() * v;
                ll.setX(v1);
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }
}
