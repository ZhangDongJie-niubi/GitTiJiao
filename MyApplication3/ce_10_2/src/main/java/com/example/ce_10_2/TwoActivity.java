package com.example.ce_10_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity {
private boolean bool;
    ArrayAdapter<String> stringArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        final ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            strings.add("张东杰"+i);
        }

        stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
        View inflate = LayoutInflater.from(TwoActivity.this).inflate(R.layout.activity_two, null);
        ListView lv = findViewById(R.id.lv);
        lv.addFooterView(inflate);
        lv.setAdapter(stringArrayAdapter);
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState==SCROLL_STATE_IDLE && bool){
                    for (int i = 0; i <5 ; i++) {
                        strings.add("你好"+i);

                    }
                    stringArrayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem+visibleItemCount==totalItemCount){
                    bool=true;
                }else{
                    bool=false;
                }
            }
        });

    }
}
