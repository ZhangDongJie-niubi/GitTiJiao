package com.example.ce_15_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TwoActivity extends AppCompatActivity {
private EditText edd;
private  Intent intent;
private   String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        intent = getIntent();
        String pic = intent.getStringExtra("pic");
        String title = intent.getStringExtra("title");
        edd = findViewById(R.id.edd);

        ImageView ivvv = findViewById(R.id.ivvv);
        edd.setText(title);
        Glide.with(this).load(pic).into(ivvv);

        TextView tvvvv = findViewById(R.id.tvvvv);
        tvvvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                s = edd.getText().toString();
                intent.putExtra("s",s);
                setResult(100,intent);
            finish();
        }
        });

    }
}
