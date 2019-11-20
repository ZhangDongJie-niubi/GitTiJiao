package com.example.tao2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class TwoActivity extends AppCompatActivity {
private int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        ListView lv = findViewById(R.id.lv);

        Shu shu = new Shu(TwoActivity.this,"ku.db",null,1);
        List<ShuL> cha = shu.cha();
        Shi shi = new Shi(TwoActivity.this);
        shi.setOnLongClickListener(new Shi.OnLongClickListener() {
            @Override
            public void onLongClickListener(int i) {
                a=i;
            }
        });
        ShuL shuL = cha.get(a);
        String title = shuL.getTitle();
        String chapterName = shuL.getChapterName();
        Shi1 shi1 = new Shi1(cha,TwoActivity.this);
        lv.setAdapter(shi1);
    }
}
