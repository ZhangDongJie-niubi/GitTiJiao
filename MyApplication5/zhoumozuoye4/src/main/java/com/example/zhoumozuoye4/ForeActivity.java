package com.example.zhoumozuoye4;

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
        Shu shu = new Shu(ForeActivity.this,"ku.db",null,1);
        List<ShuL> cha = shu.cha();
        TextView tt = findViewById(R.id.tt);
        tt.setText(cha+"");
    }
}
