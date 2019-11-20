package com.example.ce_8_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity {
private  ArrayList<ArrayList<String>> shi;
private  Shi shi1;
private ArrayList<String> sheng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
         sheng = new ArrayList<>();
        sheng.add("河北");
        sheng.add("北京");
        sheng.add("河南");
       shi=new ArrayList<>();
        ArrayList<String> s = new ArrayList<>();
        ArrayList<String> h = new ArrayList<>();
        ArrayList<String> i = new ArrayList<>();
        s.add("石家庄");
        s.add("唐山");
        s.add("邯郸");
        h.add("昌平");
        h.add("丰台");
        i.add("安阳");
        i.add("濮阳");
        shi.add(s);
        shi.add(h);
        shi.add(i);
       shi1 = new Shi(this,sheng,shi);
        ExpandableListView viewById = findViewById(R.id.elv);
        viewById.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(TwoActivity.this, shi.get(groupPosition).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        viewById.setAdapter(shi1);
        TextView textView = new TextView(this);
        textView.setText("加载……");
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
