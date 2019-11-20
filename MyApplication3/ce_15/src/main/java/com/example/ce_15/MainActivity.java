package com.example.ce_15;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
private int a=5;
private Handler handler;
    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler= new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if (msg.what==0){
                    TextView tv = findViewById(R.id.tv);
                    tv.setText(a+"");
                    a--;
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
    }
}
