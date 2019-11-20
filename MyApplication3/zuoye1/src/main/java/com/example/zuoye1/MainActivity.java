package com.example.zuoye1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> sheng = new ArrayList<>();
        sheng.add("河北");
        sheng.add("北京");
        sheng.add("河南");
        ArrayList<ArrayList<String>> shi = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        ArrayList<String> j = new ArrayList<>();
        ArrayList<String> n = new ArrayList<>();
        b.add("邯郸");
        b.add("武安");
        j.add("昌平");
        j.add("丰台");
        n.add("安阳");
        n.add("濮阳");
        shi.add(b);
        shi.add(j);
        shi.add(n);
        ExpandableListView lv = findViewById(R.id.lv);
        Shi aaa = new Shi(this, sheng, shi);
        lv.setAdapter(aaa);
    }
}
