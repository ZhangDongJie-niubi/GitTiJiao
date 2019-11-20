package com.example.ce_14_1;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout dl = findViewById(R.id.dl);
        LinearLayout ll = findViewById(R.id.ll);
        NavigationView nv = findViewById(R.id.nv);
        Toolbar tb = findViewById(R.id.tb);
        tb.setTitle("首页");


        View headerView = nv.getHeaderView(0);
        ImageView viewById = headerView.findViewById(R.id.iv);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点了头", Toast.LENGTH_SHORT).show();
            }
        });
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.one:
                        Toast.makeText(MainActivity.this, "玩Android", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.two:
                        Toast.makeText(MainActivity.this, "我的音乐", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.three:
                        Toast.makeText(MainActivity.this, "我的视频", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.fore:
                        Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });


        ActionBarDrawerToggle abt = new ActionBarDrawerToggle(this, dl, tb, R.string.oppen, R.string.colse);
        dl.addDrawerListener(abt);
        abt.syncState();

    }
}
