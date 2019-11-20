package com.example.zongheti3;

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
    private int a;
    private ViewPager vp;
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
        setContentView(R.layout.activity_two);
        View three = LayoutInflater.from(this).inflate(R.layout.three, null);
        View fore = LayoutInflater.from(this).inflate(R.layout.fore, null);
        View five = LayoutInflater.from(this).inflate(R.layout.five, null);
        List<View> arr = new ArrayList<>();
        arr.add(three);
        arr.add(fore);
        arr.add(five);
        vp = findViewById(R.id.vp);
        Shi shi = new Shi(arr);
        vp.setAdapter(shi);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            timer.cancel();
            }
        },3000,3000);
        Button vp_but = five.findViewById(R.id.vp_but);
        vp_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoActivity.this,ThreeActivity.class);
                startActivity(intent);
            }
        });
    }
}
