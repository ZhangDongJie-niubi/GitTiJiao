package com.example.qimojinengc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import bean.User;

public class ThreeActivity extends AppCompatActivity {

    private List<User> cha;
    private int a;
    private Listapter listapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        cha = Util.util().cha();
        listapter = new Listapter(cha, ThreeActivity.this);
        RecyclerView lv = findViewById(R.id.lv);
        registerForContextMenu(lv);
        lv.setLayoutManager(new LinearLayoutManager(ThreeActivity.this));
        lv.setAdapter(listapter);


        listapter.setOnLongClickListener(new Listapter.OnLongClickListener() {
            @Override
            public void onLongClickListener(int position) {
              a=position;
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(1,1,1,"删除");
        menu.add(1,2,1,"修改");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                cha.remove(a);
                listapter.notifyDataSetChanged();
                break;
            case 2:

                break;
        }
        return super.onContextItemSelected(item);
    }
}
