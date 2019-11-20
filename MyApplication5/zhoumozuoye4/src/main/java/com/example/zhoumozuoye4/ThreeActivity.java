package com.example.zhoumozuoye4;

import android.content.Intent;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ThreeActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tl;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        DrawerLayout dl = findViewById(R.id.dl);
        ll = findViewById(R.id.ll);
        Toolbar tb = findViewById(R.id.tb);
        vp = findViewById(R.id.vp);
        tl = findViewById(R.id.tl);
        NavigationView nv = findViewById(R.id.nv);

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

        tb.setTitle("ToolBar");
        setSupportActionBar(tb);

        ActionBarDrawerToggle abt = new ActionBarDrawerToggle(ThreeActivity.this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(abt);
        abt.syncState();

        Fragmenta fragmenta = new Fragmenta();
        ArrayList<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        Shi2 shi2 = new Shi2(getSupportFragmentManager(), arr);
         vp.setAdapter(shi2);
        tl.setupWithViewPager(vp);
       tl.getTabAt(0).setText("項目").setIcon(R.drawable.f_selector);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bbb,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.bbb:
                Intent intent = new Intent(ThreeActivity.this,ForeActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
