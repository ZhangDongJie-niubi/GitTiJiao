package com.example.ce_10_1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> strings;
    ArrayAdapter<String> stringArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strings = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            strings.add("张东杰"+i);
        }

        stringArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,strings);
        View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.two, null);
        ListView lv = findViewById(R.id.lv);
        lv.addFooterView(inflate);
        lv.setAdapter(stringArrayAdapter);
        Button but = inflate.findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i <10 ; i++) {
                    strings.add("嘿嘿"+i);
                }
                stringArrayAdapter.notifyDataSetChanged();
            }
        });
    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,strings.get(position),Toast.LENGTH_LONG).show();
        }
    });

    }
}
