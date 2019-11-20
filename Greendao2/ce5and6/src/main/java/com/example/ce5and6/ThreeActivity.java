package com.example.ce5and6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import two.Food;
import two.Util1;

public class ThreeActivity extends AppCompatActivity {


    private Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        food = new Food();
        final EditText edt = findViewById(R.id.edt);
        Button tian1 = findViewById(R.id.tian1);
        tian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edt.getText().toString();
                String[] split = s.split(",");
                food.setId(Long.valueOf(split[0]));
                food.setName(split[1]);
                Util1.getUtil1().insert(food);
            }
        });

        final EditText edt1 = findViewById(R.id.edt1);
        Button shan1 = findViewById(R.id.shan1);
        shan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edt1.getText().toString();
                food.setId(Long.valueOf(s));
                Util1.getUtil1().delece(food);
            }
        });

        final EditText edt2 = findViewById(R.id.edt2);
        Button xiu1 = findViewById(R.id.xiu1);
        xiu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Button cha1 = findViewById(R.id.cha1);
        final EditText edt3 = findViewById(R.id.edt3);
        cha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Food> list = Util1.getUtil1().list(food);
                edt3.setText(list + "");
            }
        });

        Button tiao1 = findViewById(R.id.tiao1);
        tiao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThreeActivity.this, ForeActivity.class);
                startActivity(intent);
            }
        });
    }
}
