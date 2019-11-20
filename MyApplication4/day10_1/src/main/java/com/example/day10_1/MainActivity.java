package com.example.day10_1;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int a=0;
    private ViewPager vp;
    private Timer timer;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            a++;
            vp.setCurrentItem(a%3);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> arr = new ArrayList<>();
        arr.add("one");
        arr.add("two");
        arr.add("three");
        vp = findViewById(R.id.vp);
        Shi shi = new Shi(arr, this);
        vp.setAdapter(shi);


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               handler.sendEmptyMessage(0);
            }
        },1000,1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      timer.cancel();
      timer=null;
    }
}
