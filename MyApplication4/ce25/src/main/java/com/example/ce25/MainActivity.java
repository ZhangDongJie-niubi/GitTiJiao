package com.example.ce25;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private int a=0;
    private Timer timer;
    private ViewPager vp;
Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        a++;
        vp.setCurrentItem(a%3);
        if (a==2){
           Intent intent = new Intent(MainActivity.this,TwoActivity.class);
            startActivity(intent);
        }

    }
};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<View> list = new ArrayList<>();
        View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.two, null);
        View inflate1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.three, null);
        View inflate2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.fore, null);
        list.add(inflate);
        list.add(inflate1);
        list.add(inflate2);
        vp = findViewById(R.id.vp);
        Shi shi = new Shi(MainActivity.this,list);
        vp.setAdapter(shi);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
             handler.sendEmptyMessage(0);
            }
        },3000,3000);

        Button but = inflate2.findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TwoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       timer.cancel();
       timer=null;
    }
}
