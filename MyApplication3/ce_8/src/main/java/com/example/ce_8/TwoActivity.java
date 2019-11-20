package com.example.ce_8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity {
    private ArrayList<ArrayList<String>> shi;
    private ArrayList<String> sheng;
   private  Shi shi1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        sheng = new ArrayList<>();
        sheng.add("河北");
        sheng.add("北京");
        sheng.add("河南");

        shi = new ArrayList<>();
        ArrayList<String> s = new ArrayList<>();
        s.add("邯郸");
        s.add("武安");
        ArrayList<String> h = new ArrayList<>();
        h.add("昌平");
        h.add("丰台");
        ArrayList<String> i = new ArrayList<>();
        i.add("郑州");
        i.add("安阳");
        shi.add(s);
        shi.add(h);
        shi.add(i);
        shi1 = new Shi(this, sheng, shi);
        ExpandableListView viewById = findViewById(R.id.elv);
        viewById.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(TwoActivity.this, shi.get(groupPosition).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        viewById.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(TwoActivity.this, sheng.get(groupPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        viewById.setAdapter(shi1);
        TextView textView = new TextView(this);
        textView.setText("加載……");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for (int j = 0; j < 5; j++) {
                    sheng.add(j + "");
                   shi1.notifyDataSetChanged();
                }


            }
        });
        viewById.addFooterView(textView);


    }
}
