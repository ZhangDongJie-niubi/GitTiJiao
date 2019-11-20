package com.example.ce5and6;

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

public class ForeActivity extends AppCompatActivity {
    private Handler handler;
    private int a = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fore);
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    TextView tv = findViewById(R.id.tv);
                    a--;
                    tv.setText(a + "");
                    if (a == 0) {
                        Intent intent = new Intent(ForeActivity.this, FiveActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 1000, 1000);
        ImageView iv = findViewById(R.id.iv);
        iv.startAnimation(AnimationUtils.loadAnimation(ForeActivity.this, R.anim.aa));

    }
}
