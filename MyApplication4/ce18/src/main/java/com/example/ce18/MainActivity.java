package com.example.ce18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Shi shi;
    private int a;
    private RecyclerView rv;
    private ArrayList<String> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tb = findViewById(R.id.tb);
        tb.setTitle("ToolBar標題");
        setSupportActionBar(tb);
        rv = findViewById(R.id.rv);
        shi = new Shi(MainActivity.this);
        arr = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            arr.add("張東傑"+i);
        }
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
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
        getMenuInflater().inflate(R.menu.bbb,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.o:
                break;
            case R.id.t:
                arr.remove(a);
                shi.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.aaa,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.one:
                Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
