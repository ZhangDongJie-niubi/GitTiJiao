package com.example.day72;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.dv);
        Shi shi = new Shi(this);


        List<String> reusltList = new ArrayList<>();

        for (int x=0;x<33;x++){

            reusltList.add("file--"+x);
        }

        shi.add(reusltList);
        recyclerView.setAdapter(shi);
    }
}
