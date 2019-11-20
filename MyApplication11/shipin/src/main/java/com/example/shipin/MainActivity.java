package com.example.shipin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private String[] vedios = {Environment.getExternalStorageDirectory() + "/下载/Video/英雄联盟赛事官网-腾讯游戏.mp4"};
    private VideoView vv;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = findViewById(R.id.but);
        Button but1 = findViewById(R.id.but1);
        Button but2 = findViewById(R.id.but2);
        vv = findViewById(R.id.vv);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(vedios[0]), "video/mp4");
                startActivity(intent);
            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaController mediaController = new MediaController(MainActivity.this);
                vv.setMediaController(mediaController);
                vv.setVideoPath(vedios[i]);
                 vv.start();
                mediaController.setPrevNextListeners(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i++;
                        if (i > vedios.length - 1) {
                            i = 0;
                        }
                        vv.setVideoPath(vedios[i]);
                        vv.start();
                    }
                }, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        i--;
                        if (i < 0) {
                            i = vedios.length - 1;
                        }
                        vv.setVideoPath(vedios[i]);
                        vv.start();
                    }
                });
            }
            });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });

    }
}
