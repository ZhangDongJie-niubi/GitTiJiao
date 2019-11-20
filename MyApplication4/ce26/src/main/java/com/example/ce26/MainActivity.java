package com.example.ce26;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp);
        tl = findViewById(R.id.tl);
        tl.addTab(tl.newTab().setText("首页"));
        tl.addTab(tl.newTab().setText("消息"));
        tl.addTab(tl.newTab().setText("发现"));
        tl.addTab(tl.newTab().setText("我的"));


        Fragmenta fragmenta = new Fragmenta();
        Fragmentb fragmentb = new Fragmentb();
        Fragmentc fragmentc = new Fragmentc();
        Fragmentd fragmentd = new Fragmentd();

        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        arr.add(fragmentb);
        arr.add(fragmentc);
        arr.add(fragmentd);
        Shi shi = new Shi(getSupportFragmentManager(), arr);
        vp.setAdapter(shi);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("首页").setIcon(R.drawable.a_selector);
        tl.getTabAt(1).setText("消息").setIcon(R.drawable.a_selector);
        tl.getTabAt(2).setText("发现").setIcon(R.drawable.a_selector);
        tl.getTabAt(3).setText("我的").setIcon(R.drawable.a_selector);
    }
}
