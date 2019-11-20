package com.example.qimojineng1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThreeActivity extends AppCompatActivity {

    private EditText neirong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Button baocun = findViewById(R.id.baocun);
        neirong = findViewById(R.id.neirong);
        baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = neirong.getText().toString();
                Food food = new Food();
                food.setNeirong(s);
                Util.util().insert(food);
                Intent intent = new Intent(ThreeActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });

    }
}
