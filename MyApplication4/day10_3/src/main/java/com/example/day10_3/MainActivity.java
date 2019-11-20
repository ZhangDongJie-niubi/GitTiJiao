package com.example.day10_3;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewById = findViewById(R.id.vp);
        ArrayList<Fragmenta> arr = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            Fragmenta fragmenta = new Fragmenta();
            Bundle bundle = new Bundle();
            bundle.putString("data","张东杰"+i);
            fragmenta.setArguments(bundle);
            arr.add(fragmenta);
        }
        Shi shi = new Shi(getSupportFragmentManager(), arr);
        viewById.setAdapter(shi);
    }
}
