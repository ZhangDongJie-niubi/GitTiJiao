package com.example.zongheti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class ForeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fore);
        ListView lv = findViewById(R.id.lv);
        Shu shu = new Shu(this,"ku.db",null,1);
        List<ShuL> shan = shu.shan();
        Shi3 shi3 = new Shi3(ForeActivity.this,shan);
        lv.setAdapter(shi3);
    }
}
