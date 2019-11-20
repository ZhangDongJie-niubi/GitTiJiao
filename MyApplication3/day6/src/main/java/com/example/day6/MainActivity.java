package com.example.day6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 private  ArrayAdapter<String> aa;
   private ArrayList<String> arr;
    private  ListView lv;
private int zxc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= findViewById(R.id.lv);
         arr = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arr.add("张东杰" + i);
        }
         aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arr);
      lv.setAdapter(aa);
      lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
          @Override
          public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                zxc=position;
              return false;
          }
      });
      registerForContextMenu(lv);
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

                String item1 = aa.getItem(zxc);
                aa.remove(item1);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        unregisterForContextMenu(lv);
        super.onDestroy();
    }
}