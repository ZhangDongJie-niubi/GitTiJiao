package com.example.day7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  int qw;
    private RecyclerView re;
    private ArrayList<String> list;
    private Shi shi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        re = findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(this));
        shi = new Shi(this);
        re.setAdapter(shi);
        list = new ArrayList<>();
        for (int a = 0; a < 20; a++) {
            list.add("张东杰"+a);
        }
        shi.add(list);
       shi.setOnClickListener(new Shi.OnClickListener() {
           @Override
           public void onItemClick(int i) {
               Toast.makeText(MainActivity.this, "点击了"+i, Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onItemLongClick(int i) {
               qw=i;
           }
       });
       registerForContextMenu(re);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.aaa,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.one:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
                shi.remove(qw);
                break;

        }
        return super.onContextItemSelected(item);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterForContextMenu(re);
    }
//    class aaa implements Shi.OnClickListener{
//
//        @Override
//        public void onItemClick(int i) {
//            Toast.makeText(MainActivity.this, "点击了"+i, Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onItemLongClick(int i) {
//             a=i;
//        }
//    }

}
