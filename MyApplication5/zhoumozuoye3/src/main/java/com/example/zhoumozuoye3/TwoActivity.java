package com.example.zhoumozuoye3;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TwoActivity extends AppCompatActivity {
    private ViewPager vp;
    private int a=0;
Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        a++;
        vp.setCurrentItem(a%3);
        super.handleMessage(msg);
    }
};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        View inflate = LayoutInflater.from(TwoActivity.this).inflate(R.layout.three, null);
        View inflate1 = LayoutInflater.from(TwoActivity.this).inflate(R.layout.fore, null);
        View inflate2 = LayoutInflater.from(TwoActivity.this).inflate(R.layout.five, null);
        List <View> arr = new ArrayList<>();
        arr.add(inflate);
        arr.add(inflate1);
        arr.add(inflate2);
        vp = findViewById(R.id.vp);
        Shi shi = new Shi(arr, TwoActivity.this);
        vp.setAdapter(shi);

        Timer timer = new Timer();
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
                Intent intent = new Intent(TwoActivity.this,ThreeActivity.class);
                startActivity(intent);
            }
        });

    }
}
