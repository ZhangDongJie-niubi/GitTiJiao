package com.example.zongheti3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class Fragmentb extends Fragment {

    private MediaPlayer mediaPlayer;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.ten, null);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
        String s = Environment.getExternalStorageDirectory() + File.separator + "aaaa.mp3";
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(s);
            mediaPlayer.prepare();

        } catch (Exception e) {
            e.printStackTrace();
        }


        Button but = inflate.findViewById(R.id.but);
        Button but1 = inflate.findViewById(R.id.but1);
        Button but2 = inflate.findViewById(R.id.but2);
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
