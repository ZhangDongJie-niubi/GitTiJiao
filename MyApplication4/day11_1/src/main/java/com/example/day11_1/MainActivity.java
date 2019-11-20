package com.example.day11_1;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Fragmenta fragmenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.vp);
        TabLayout tb = findViewById(R.id.tb);

        List<Fragmenta> arr = new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            fragmenta = new Fragmenta();
            Bundle bundle = new Bundle();
            bundle.putString("data","DNF"+i);
               fragmenta.setArguments(bundle);
               arr.add(fragmenta);

               }
               Shi shi = new Shi(getSupportFragmentManager(), arr);
               vp.setAdapter(shi);
               tb.setupWithViewPager(vp);
               tb.getTabAt(0).setText("123").setIcon(R.drawable.ic_launcher_background);
               tb.getTabAt(1).setText("456").setIcon(R.drawable.ic_launcher_background);
               tb.getTabAt(2).setText("789").setIcon(R.drawable.ic_launcher_background);
               }
               }
