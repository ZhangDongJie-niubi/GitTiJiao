package com.example.zongheti3;

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
private  Handler handler;
private int a=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==0){
                    TextView text_dao = findViewById(R.id.text_dao);
                    a--;
                    text_dao.setText(a+"");
                    if (a==0){
                        Intent intent = new Intent(MainActivity.this,TwoActivity.class);
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
                 if (a==0){
                     timer.cancel();
                 }
            }
        },1000,1000);
        ImageView image_dong = findViewById(R.id.image_dong);
        image_dong.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.donghua));

    }
}
