package com.example.ce1;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class TwoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        DrawerLayout dl = findViewById(R.id.dl);
        LinearLayout ll = findViewById(R.id.ll);
        TabLayout tl = findViewById(R.id.tl);
        Toolbar tb = findViewById(R.id.tb);
        ViewPager vp = findViewById(R.id.vp);
        NavigationView nv = findViewById(R.id.nv);

        ActionBarDrawerToggle abd = new ActionBarDrawerToggle(this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(abd);
        abd.syncState();

        tb.setTitle("ToolBar");
        setSupportActionBar(tb);

        Fragmenta fragmenta = new Fragmenta();
        Fragmentb fragmentb = new Fragmentb();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        arr.add(fragmentb);
        Shi1 shi1 = new Shi1(getSupportFragmentManager(), arr);
        vp.setAdapter(shi1);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("我的");
        tl.getTabAt(1).setText("首页");
    }


}
