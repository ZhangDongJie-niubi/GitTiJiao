package com.example.day11_2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager rv = findViewById(R.id.rv);
        TabLayout tl = findViewById(R.id.tl);
        List<Fragmenta> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Fragmenta fragmenta = new Fragmenta();
            Bundle bundle = new Bundle();
            bundle.putString("data", "DNF" + i);
            fragmenta.setArguments(bundle);
            arr.add(fragmenta);
        }

        Shi shi = new Shi(getSupportFragmentManager(), arr);
        rv.setAdapter(shi);
        tl.setupWithViewPager(rv);
        tl.getTabAt(0).setText("0").setIcon(R.drawable.ic_launcher_background);
        tl.getTabAt(1).setText("0").setIcon(R.drawable.ic_launcher_background);
        tl.getTabAt(2).setText("0").setIcon(R.drawable.ic_launcher_background);
    }
}
