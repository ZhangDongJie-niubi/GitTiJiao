package com.example.zhoumozuoye1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import bean.Student;

public class ShuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shu);
        Shu shu = new Shu(ShuActivity.this, "stus.db", null, 1);
        TextView tv = findViewById(R.id.tv);
        tv.setText(shu.selectAll() + "");
        TextView tv1 = findViewById(R.id.tv);
    }
}
