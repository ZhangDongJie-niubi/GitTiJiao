package com.example.zongheti2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class ForeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fore);
        TextView tv3 = findViewById(R.id.tv3);
        Shu shu = new Shu(this,"ku.db",null,1);
        List<ShuL> cha = shu.cha();
        tv3.setText(cha+"");
    }
}
