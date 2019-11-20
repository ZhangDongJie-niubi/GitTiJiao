package com.example.ce_14;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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
        Toolbar tb = findViewById(R.id.tb);
        LinearLayout ll = findViewById(R.id.ll);
        NavigationView nv = findViewById(R.id.nv);
        nv.setItemIconTintList(null);
        tb.setTitle("                  首页");
        setSupportActionBar(tb);

        //側滑頭部監聽
        View headerView = nv.getHeaderView(0);
        ImageView iv = headerView.findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "这是头部", Toast.LENGTH_SHORT).show();
            }
        });

        //側滑中每個條目的監聽
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ont:
                        Toast.makeText(MainActivity.this, "点击了玩Android", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.two:
                        Toast.makeText(MainActivity.this, "点击了我的音乐", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.three:
                        Toast.makeText(MainActivity.this, "点击了我的视频", Toast.LENGTH_SHORT).show();
                    case R.id.fore:
                        Toast.makeText(MainActivity.this, "点击了设置", Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,dl,tb,R.string.oppe,R.string.close);
        dl.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
//創建菜單
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bbb,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
