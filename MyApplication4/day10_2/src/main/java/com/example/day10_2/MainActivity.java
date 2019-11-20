package com.example.day10_2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.youth.banner.Banner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.vp);
        ArrayList<Fagementa> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Fagementa fagementa = new Fagementa();
            Bundle bundle = new Bundle();
            bundle.putString("data","张东杰"+i);
            fagementa.setArguments(bundle);
            arr.add(fagementa);
        }
        Shi shi = new Shi(getSupportFragmentManager(), arr);
        vp.setAdapter(shi);
    }
}
