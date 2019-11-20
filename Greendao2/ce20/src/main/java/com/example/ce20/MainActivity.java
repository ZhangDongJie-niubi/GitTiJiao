package com.example.ce20;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but1 = findViewById(R.id.but1);
        vp = findViewById(R.id.vp);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragmentzhuye fragmentzhuye = new Fragmentzhuye();
                List<Fragment> arr = new ArrayList<>();
                arr.add(fragmentzhuye);
                Shi1 shi1 = new Shi1(getSupportFragmentManager(), arr);
                vp.setAdapter(shi1);

            }
        });
        Button but2 = findViewById(R.id.but2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragmentwangye fragmentwangye = new Fragmentwangye();
                List<Fragment> arr = new ArrayList<>();
                arr.add(fragmentwangye);
                Shi1 shi1 = new Shi1(getSupportFragmentManager(), arr);
                vp.setAdapter(shi1);
            }
        });
    }
}
