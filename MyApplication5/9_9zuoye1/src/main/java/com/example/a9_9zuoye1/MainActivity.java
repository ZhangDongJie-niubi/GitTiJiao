package com.example.a9_9zuoye1;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

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
        Shi1 shi1 = new Shi1(getSupportFragmentManager(), arr);
        vp.setAdapter(shi1);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("项目1").setIcon(R.drawable.ic_launcher_background);
    }
}
