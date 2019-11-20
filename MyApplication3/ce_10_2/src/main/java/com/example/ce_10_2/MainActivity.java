package com.example.ce_10_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image = findViewById(R.id.iv);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.sca);
        image.startAnimation(animation);
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(2000);
                   Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                   startActivity(intent);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }).start();
    }
}
