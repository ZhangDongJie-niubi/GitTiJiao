package com.example.zongheti;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        DrawerLayout dl = findViewById(R.id.dl);
        final LinearLayout ll = findViewById(R.id.ll);
        Toolbar tb = findViewById(R.id.tb);
        ViewPager vp1 = findViewById(R.id.vp1);
        TabLayout tl = findViewById(R.id.tl);
        NavigationView nv = findViewById(R.id.nv);
        tb.setTitle("ToolBar標題");

        setSupportActionBar(tb);
        ActionBarDrawerToggle abd = new ActionBarDrawerToggle(ThreeActivity.this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(abd);
        abd.syncState();


        Fragmenta fragmenta = new Fragmenta();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);

        Shi2 shi2 = new Shi2(getSupportFragmentManager(), arr);
        vp1.setAdapter(shi2);
        tl.setupWithViewPager(vp1);
        tl.getTabAt(0).setText("首页").setIcon(R.drawable.a_selector);
//        tl.getTabAt(1).setText("知识体系").setIcon(R.drawable.a_selector);
//        tl.getTabAt(2).setText("公众号").setIcon(R.drawable.a_selector);
//        tl.getTabAt(3).setText("导航").setIcon(R.drawable.a_selector);
//        tl.getTabAt(4).setText("项目").setIcon(R.drawable.a_selector);




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
                Intent intent = new Intent(ThreeActivity.this,ForeActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
