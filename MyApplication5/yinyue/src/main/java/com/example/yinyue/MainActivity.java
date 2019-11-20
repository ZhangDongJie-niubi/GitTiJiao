package com.example.yinyue;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = findViewById(R.id.but);
        Button but1 = findViewById(R.id.but1);
        Button but2 = findViewById(R.id.but2);
        if (mediaPlayer==null){
            mediaPlayer = new MediaPlayer();
        }
        
        String s = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Music/aaa.mp3";
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(s);
            mediaPlayer.prepare();
        } catch (IOException e) {
        }
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             mediaPlayer.start();
            }
        });
         but1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            mediaPlayer.pause();
             }
         });

         but2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
             mediaPlayer.stop();
             }
         });
    }
}
