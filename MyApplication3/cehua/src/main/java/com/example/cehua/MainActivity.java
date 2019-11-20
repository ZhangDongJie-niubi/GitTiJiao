package com.example.cehua;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private int A=1;
private int B=2;
private int C=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DrawerLayout dl = findViewById(R.id.dl);
        LinearLayout ll = findViewById(R.id.ll);
        NavigationView nv = findViewById(R.id.nv);
        Toolbar tb = findViewById(R.id.tb);
        setSupportActionBar(tb);

        //点击头部
        View headerView = nv.getHeaderView(0);
        ImageView viewById = headerView.findViewById(R.id.iv);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "156156", Toast.LENGTH_SHORT).show();
            }
        });

         nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                 switch (menuItem.getItemId()){
                     case R.id.one:
                         Toast.makeText(MainActivity.this, "333", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.two:
                         Toast.makeText(MainActivity.this, "666", Toast.LENGTH_SHORT).show();
                         break;
                 }
                 dl.closeDrawer(Gravity.LEFT);
                 return false;
             }
         });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, dl,tb, R.string.oppe, R.string.close);
        dl.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aaa,menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case A:
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
