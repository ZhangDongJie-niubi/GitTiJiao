package com.example.myapplication;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class RecycleViewAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_acitivity);
        DrawerLayout dl = findViewById(R.id.dl);
        LinearLayout ll = findViewById(R.id.ll);
        Toolbar tb = findViewById(R.id.tb);
        TabLayout tl = findViewById(R.id.tl);
        NavigationView nv = findViewById(R.id.nv);

        ActionBarDrawerToggle abd = new ActionBarDrawerToggle(this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(abd);
        abd.syncState();

        tb.setTitle("Toolbar");
        setSupportActionBar(tb);


    }
}
