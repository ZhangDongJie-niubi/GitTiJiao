package com.example.tao;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.vp1);
        TabLayout tl = findViewById(R.id.tl1);
        Fragmenta fragmenta = new Fragmenta();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        Shi2 shi3 = new Shi2(getSupportFragmentManager(),arr);
        vp.setAdapter(shi3);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("項目").setIcon(R.drawable.ic_launcher_background);
    }
}
