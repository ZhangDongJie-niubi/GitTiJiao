package com.example.lianxi500;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.lianxi500.adpter.FragmentAdpter;
import com.example.lianxi500.fragment.Fragmenta;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.vp);
        TabLayout tl = findViewById(R.id.tl);


        List<Fragment> arr = new ArrayList<>();
        Fragmenta fragmenta = new Fragmenta();
        arr.add(fragmenta);

        FragmentAdpter fragmentAdpter = new FragmentAdpter(getSupportFragmentManager(), arr);
        vp.setAdapter(fragmentAdpter);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("123");


    }
}
