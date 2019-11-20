package com.example.day6_1;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private int a;
    private ListView lv;
    private boolean bool;
    private ArrayAdapter arrayAdapter;
    private ArrayList<String> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout dl = findViewById(R.id.dl);
        LinearLayout ll = findViewById(R.id.ll);
        NavigationView nv = findViewById(R.id.nv);
        Toolbar tb = findViewById(R.id.tb);
        setSupportActionBar(tb);
        ActionBarDrawerToggle ab = new ActionBarDrawerToggle(this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(ab);
        ab.syncState();
        View headerView = nv.getHeaderView(0);
        ImageView viewById = headerView.findViewById(R.id.iv);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "點擊了頭部", Toast.LENGTH_SHORT).show();
            }
        });
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.one:
                        Toast.makeText(MainActivity.this, "點擊了你好", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        arr = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arr.add("張東jie" + i);
        }
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        lv = findViewById(R.id.lv);
        View inflate = LayoutInflater.from(this).inflate(R.layout.three, null);
        lv.addFooterView(inflate);
        lv.setAdapter(arrayAdapter);
        registerForContextMenu(lv);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                a = position;
                return false;
            }
        });

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE && bool) {
                    for (int i = 0; i < 5; i++) {
                        arr.add("" + i);
                    }
                    arrayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount > 0) {
                    bool = true;
                } else {
                    bool = false;
                }
            }
        });
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.aaa, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one:
                arr.remove(a);
                arrayAdapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aaa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one:
                Toast.makeText(this, "您點擊了你好", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        unregisterForContextMenu(lv);
        super.onDestroy();
    }
}
