package com.example.day5_1;

import android.os.strictmode.NetworkViolation;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout dl = findViewById(R.id.dl);
        LinearLayout ll = findViewById(R.id.ll);
        Toolbar tb = findViewById(R.id.tb);
        NavigationView nv = findViewById(R.id.nv);
        //  创建侧滑和toolbar 联动对象
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, dl, tb, R.string.open, R.string.close);
        // 关联drawerlayout 和  toolbar
        dl.addDrawerListener(actionBarDrawerToggle);
        // 同步状态
        actionBarDrawerToggle.syncState();
//        NavigationView
    }
}
