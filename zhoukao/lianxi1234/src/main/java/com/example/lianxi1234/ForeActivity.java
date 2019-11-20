package com.example.lianxi1234;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jiehe.dao.Util;

public class ForeActivity extends AppCompatActivity {

    private ImageView iv2;
    private TextView tv2;
    private String pic;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fore);
        Intent intent = getIntent();
        pic = intent.getStringExtra("pic");
        title = intent.getStringExtra("title");
        Button but = findViewById(R.id.but);
        iv2 = findViewById(R.id.iv2);
        tv2 = findViewById(R.id.tv2);
        Glide.with(ForeActivity.this).load(pic).into(iv2);
        tv2.setText(title);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Foods foods = new Foods();
                foods.setPic(pic);
                foods.setTitle(title);
                Util.getutil().insert(foods);
                Toast.makeText(ForeActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
