package com.example.ce_15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Intent intent = getIntent();
        String pic = intent.getStringExtra("pic");
        String title = intent.getStringExtra("title");
        ImageView viewById = findViewById(R.id.image);
        TextView viewById1 = findViewById(R.id.text);
        Toolbar viewById2 = findViewById(R.id.too);
        viewById2.setTitle("修改");
        setSupportActionBar(viewById2);
        viewById1.setText(title);
        new Shi.Yi(viewById).execute(pic);
    }
}
