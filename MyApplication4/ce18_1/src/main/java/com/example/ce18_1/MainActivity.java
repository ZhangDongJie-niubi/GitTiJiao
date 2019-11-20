package com.example.ce18_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  int a;
    private Shi shi;
    private ArrayList<String> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tb = findViewById(R.id.tb);
        tb.setTitle("Toolbar");
        setSupportActionBar(tb);
        arr = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
              arr.add("张东杰"+i);
        }
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        shi = new Shi(MainActivity.this);
        rv.setAdapter(shi);
        shi.add(arr);
        registerForContextMenu(rv);
        shi.setOnLongClickListener(new Shi.OnLongClickListener() {
            @Override
            public void onLongClickListener(int i) {
                a=i;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.aa,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.one:
                break;
            case R.id.two:
              arr.remove(a);
              shi.notifyDataSetChanged();
                break;
        }

        return super.onContextItemSelected(item);
    }
}
