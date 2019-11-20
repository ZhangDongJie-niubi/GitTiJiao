package com.example.ce17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Intent intent = getIntent();
        ImageView ivv = findViewById(R.id.ivv);
        EditText tvv = findViewById(R.id.tvv);
        String pic = intent.getStringExtra("pic");
        String title = intent.getStringExtra("title");
        tvv.setText(title);
        Glide.with(this).load(pic).into(ivv);
    }
}
