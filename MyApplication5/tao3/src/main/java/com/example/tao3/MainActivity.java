package com.example.tao3;

import android.support.annotation.NonNull;
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
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1
        DrawerLayout dl = findViewById(R.id.dl);
        final LinearLayout ll = findViewById(R.id.ll);
        Toolbar tb = findViewById(R.id.tb);
        ViewPager vp = findViewById(R.id.vp);
        TabLayout tl = findViewById(R.id.tl);
        NavigationView nv = findViewById(R.id.nv);

        tb.setTitle("標題");
        setSupportActionBar(tb);

        ActionBarDrawerToggle abd = new ActionBarDrawerToggle(this, dl, tb, R.string.oppen, R.string.colse);
        dl.addDrawerListener(abd);
        abd.syncState();

        Fragementa fragementa = new Fragementa();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragementa);
        Shi1 shi1 = new Shi1(getSupportFragmentManager(), arr);
        tl.setupWithViewPager(vp);
        vp.setAdapter(shi1);
        tl.getTabAt(0).setText("項目").setIcon(R.drawable.follow);
        dl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
                float v1 = view.getWidth() * v;
                ll.setX(v1);
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
