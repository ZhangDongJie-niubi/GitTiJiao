package com.example.ce15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ThreeActivity extends AppCompatActivity {

    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        final Intent intent = getIntent();
        String pic = intent.getStringExtra("pic");
        String title = intent.getStringExtra("title");
        ImageView ivv = findViewById(R.id.ivv);
        et = findViewById(R.id.et);
        et.setText(title);
        Glide.with(ThreeActivity.this).load(pic).into(ivv);
        Button but = findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et.getText().toString();
                Intent intent1 = new Intent();
                intent1.putExtra("s",s);
                setResult(100,intent1);
                finish();

            }
        });
    }
}
