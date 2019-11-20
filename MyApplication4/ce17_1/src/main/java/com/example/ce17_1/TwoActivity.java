package com.example.ce17_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TwoActivity extends AppCompatActivity {

    private ImageView ivv;
    private TextView tvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        final Intent intent = getIntent();
        String pic = intent.getStringExtra("pic");
        String title = intent.getStringExtra("title");
        ivv = findViewById(R.id.ivv);
        tvv = findViewById(R.id.tvv);
        tvv.setText(title);
        Glide.with(TwoActivity.this).load(pic).into(ivv);
        Button but = findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = tvv.getText().toString();
                Intent intent1 = new Intent();
                intent1.putExtra("s", s);
                setResult(100,intent1);
                finish();

            }
        });
    }
}
