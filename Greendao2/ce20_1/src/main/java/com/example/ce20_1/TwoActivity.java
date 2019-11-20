package com.example.ce20_1;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Fragmenta fragmenta = new Fragmenta();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        Shi1 shi1 = new Shi1(getSupportFragmentManager(), arr);
        ViewPager vp = findViewById(R.id.vp);
        vp.setAdapter(shi1);
        TabLayout tl = findViewById(R.id.tl);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("Fragment1");
    }
}
