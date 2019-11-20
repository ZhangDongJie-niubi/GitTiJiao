package com.example.ce17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Intent intent = getIntent();
        String pic = intent.getStringExtra("pic");
        String title = intent.getStringExtra("title");
        TextView viewById = findViewById(R.id.tvv);
        ImageView ivv = findViewById(R.id.ivv);
        viewById.setText(title);
        Glide.with(this).load(pic).into(ivv);

    }
}
