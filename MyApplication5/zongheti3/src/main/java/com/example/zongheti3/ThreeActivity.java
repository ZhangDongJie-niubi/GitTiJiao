package com.example.zongheti3;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ThreeActivity extends AppCompatActivity {

    private LinearLayout ll;
    private DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        dl = findViewById(R.id.dl);
        ll = findViewById(R.id.ll);
        Toolbar tb = findViewById(R.id.tb);
        TabLayout tl = findViewById(R.id.tl);
        NavigationView nv = findViewById(R.id.nv);

        ActionBarDrawerToggle abd = new ActionBarDrawerToggle(this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(abd);
        abd.syncState();

        tb.setTitle("标题");
        setSupportActionBar(tb);

        ViewPager vp = findViewById(R.id.vp);
        Fragmenta fragmenta = new Fragmenta();
        Fragmentb fragmentb = new Fragmentb();
        Fragmentc fragmentc = new Fragmentc();
        Fragmentd fragmentd = new Fragmentd();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        arr.add(fragmentb);
        arr.add(fragmentc);
        arr.add(fragmentd);
        Shi2 shi2 = new Shi2(getSupportFragmentManager(),arr);
        vp.setAdapter(shi2);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("项目").setIcon(R.drawable.a_selector);
         tl.getTabAt(1).setText("知识体系").setIcon(R.drawable.a_selector);
        tl.getTabAt(2).setText("导航").setIcon(R.drawable.a_selector);
        tl.getTabAt(3).setText("打电话").setIcon(R.drawable.a_selector);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,1,1,"我的收藏");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Intent intent = new Intent();
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
