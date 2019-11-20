package com.example.zhoumozuoye1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ThreeActivity extends AppCompatActivity {

    private LinearLayout ll;
    private Toolbar tb;
    private ViewPager vp;
    private TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        DrawerLayout dl = findViewById(R.id.dl);
        tb = findViewById(R.id.tb);
        ll = findViewById(R.id.ll);
        vp = findViewById(R.id.vp);
        tl = findViewById(R.id.tl);
        tb.setTitle("ToolBar標題");
        setSupportActionBar(tb);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(ThreeActivity.this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(abdt);
        abdt.syncState();
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
        Fragmenta fragmenta = new Fragmenta();
        Fragmentb fragmentb = new Fragmentb();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        arr.add(fragmentb);

        Shi2 shi2 = new Shi2(getSupportFragmentManager(), arr);
        vp.setAdapter(shi2);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("首页").setIcon(R.drawable.aaaa_selector);
        tl.getTabAt(1).setText("导航").setIcon(R.drawable.aaaa_selector);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bbb, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.o:
                Toast.makeText(this, "我的收藏", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThreeActivity.this,ShuActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
