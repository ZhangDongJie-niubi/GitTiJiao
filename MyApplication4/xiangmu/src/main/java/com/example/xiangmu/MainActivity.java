package com.example.xiangmu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mTb;
    private ViewPager mVp;
    private TabLayout mTl;
    private LinearLayout mLl;
    private NavigationView mNv;
    private DrawerLayout mDl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mTb = (Toolbar) findViewById(R.id.tb);
        mDl = (DrawerLayout) findViewById(R.id.dl);
        mTb.setTitle("我的");
        setSupportActionBar(mTb);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this, mDl, mTb, R.string.oppen, R.string.close);
        mDl.addDrawerListener(abdt);
        abdt.syncState();

        mVp = (ViewPager) findViewById(R.id.vp);
        mTl = (TabLayout) findViewById(R.id.tl);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mNv = (NavigationView) findViewById(R.id.nv);
        List<Fragment> arr = new ArrayList<>();
        arr.add(new Fragmenta());
        arr.add(new Fragmentb());
        Shi1 shi1 = new Shi1(getSupportFragmentManager(),arr);
        mVp.setAdapter(shi1);
        mTl.setupWithViewPager(mVp);
        mTl.getTabAt(0).setText("我的").setIcon(R.drawable.bian);
        mTl.getTabAt(1).setText("你的").setIcon(R.drawable.bian);






        mDl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
                mLl.setX(view.getWidth()*v);
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
