package com.example.shoudongjiazai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> strings;
    private ArrayAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("你好" + i);
        }
        ListView lv = findViewById(R.id.lv);
        View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.two, null);
        lv.addFooterView(inflate);
        aa = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,strings);
        lv.setAdapter(aa);
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
             boolean isButtom = false;
             //SCROLL_STATE_IDLE  静止
             //SCROLL_STATE_TOUCH_SCROLL 拖动
            //SCROLL_STATE_FLING  滑翔
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE && isButtom) {
                    for (int i = 0; i < 10; i++) {
                        strings.add("我不好" + i);
                    }
                    aa.notifyDataSetChanged();
                }
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    if (firstVisibleItem+visibleItemCount==totalItemCount&&totalItemCount>0){
                        isButtom=true;
                    }else{
                        isButtom=false;
                    }
            }
        });
    }
}              //物联网-H1903B-张东杰  15731013663