package com.example.zhoumozuoye3;

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
        TextView tvv = findViewById(R.id.tvv);
        Shu shu = new Shu(ForeActivity.this, "ku.db", null, 1);
        List<ShuL> remove = shu.remove();
        tvv.setText(remove+"");
    }
}
