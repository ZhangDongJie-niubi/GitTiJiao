package com.example.ce_8;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
private int a=5;
private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what==0){
                    TextView tv = findViewById(R.id.tv);
                    a--;
                    tv.setText(a+"");

                    if (a==0){
                        Intent intent = new Intent(MainActivity.this,TwoActivity.class);
                        startActivity(intent);
                    }
                }
                return false;
            }
        });
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
                if (a==0){
                    timer.cancel();
                }
            }
        },1000,1000);
        ImageView viewById = findViewById(R.id.iv);
        viewById.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.jian));


    }
}
