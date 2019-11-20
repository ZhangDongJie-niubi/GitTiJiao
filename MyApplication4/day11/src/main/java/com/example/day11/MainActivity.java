package com.example.day11;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.vp);
        TabLayout tl = findViewById(R.id.tl);
        this.tl = findViewById(R.id.tl);
//        tl.addTab(tl.newTab().setText("TAB_1").setIcon(R.drawable.ic_launcher_background));
//        tl.addTab(tl.newTab().setText("TAB_2").setIcon(R.drawable.ic_launcher_background));
//        tl.addTab(tl.newTab().setText("TAB_3").setIcon(R.drawable.ic_launcher_background));
        List<Fragmenta> arr  = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Fragmenta fragmenta = new Fragmenta();
            Bundle bundle = new Bundle();
            bundle.putString("data","DNF"+i);
            fragmenta.setArguments(bundle);
            arr.add(fragmenta);
        }
        Shi shi = new Shi(getSupportFragmentManager(), arr);
        vp.setAdapter(shi);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("TAB_0").setIcon(R.drawable.ic_launcher_background);
        tl.getTabAt(1).setText("TAB_1").setIcon(R.drawable.ic_launcher_background);
        tl.getTabAt(2).setText("TAB_2").setIcon(R.drawable.ic_launcher_background);
   
    }
}
