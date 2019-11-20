package com.example.xiangmu;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tb = findViewById(R.id.tb);
        setSupportActionBar(tb);
        tb.setTitle("你好");
        DrawerLayout dl = findViewById(R.id.dl);
        ActionBarDrawerToggle abd = new ActionBarDrawerToggle(this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(abd);

    }
}
