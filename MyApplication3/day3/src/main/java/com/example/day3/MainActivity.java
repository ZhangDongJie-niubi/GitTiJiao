package com.example.day3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<ArrayList<String>> shi = new ArrayList<>();
        final ArrayList<String> sheng = new ArrayList<>();
        sheng.add("河北");
        sheng.add("北京");
        sheng.add("河南");
        ArrayList<String> s = new ArrayList<>();
        s.add("邯郸");
        s.add("石家庄");
        ArrayList<String> h = new ArrayList<>();
        h.add("丰台");
        h.add("昌平");
        ArrayList<String> i = new ArrayList<>();
        i.add("郑州");
        i.add("安阳");
        shi.add(s);
        shi.add(h);
        shi.add(i);
        ExpandableListView elv = findViewById(R.id.elv);
        Shi shi1 = new Shi(this, shi, sheng);
        elv.setAdapter(shi1);
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, shi.get(groupPosition).get(childPosition)+"", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(MainActivity.this, sheng.get(groupPosition)+"", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        elv.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(MainActivity.this, "您收起来了", Toast.LENGTH_SHORT).show();
            }
        });
        elv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(MainActivity.this, "您展开了", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
