package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    private int a = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==0) {
                    TextView tv = findViewById(R.id.tv);
                    a--;
                    tv.setText(a+"");
                    if (a == 0) {
                        Intent intent = new Intent(MainActivity.this, RecycleViewAcitivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
                if (a == 0) {
                    timer.cancel();
                }
            }
        }, 1000, 1000);
        ImageView iv = findViewById(R.id.iv);
        iv.startAnimation(AnimationUtils.loadAnimation(this, R.anim.aaa));
    }
}
