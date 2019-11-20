package com.example.ce3_2;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Toolbar tb = findViewById(R.id.tb);
        ViewPager vp = findViewById(R.id.vp1);
        TabLayout tl = findViewById(R.id.tl);
        NavigationView nv = findViewById(R.id.nv);
        ActionBarDrawerToggle abd = new ActionBarDrawerToggle(this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(abd);
        abd.syncState();

        tb.setTitle("Toolbar");
        setSupportActionBar(tb);

        Fragmenta fragmenta = new Fragmenta();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        Shi2 shi2 = new Shi2(getSupportFragmentManager(), arr);
        vp.setAdapter(shi2);

        View headerView = nv.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoActivity.this,ThreeActivity.class);
                startActivity(intent);
            }
        });

        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("首頁");
    }
}
