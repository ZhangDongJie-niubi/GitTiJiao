package com.example.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.greendao.dao.DbUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button zeng = findViewById(R.id.zeng);
        Button shan = findViewById(R.id.shan);
        zeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = 0; i < 10; i++) {
                    Food food = new Food();
                    food.setId(Long.valueOf(i));
                    food.setName("ads" + i);
                    food.setSex("男");
                    DbUtil.getDbUtil().insert(food);
                }
            }
        });
        shan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Food food = new Food();
                food.setSex("男");
                food.setName("qwe");
                food.setId(Long.valueOf(10));
                DbUtil.getDbUtil().delecte(food);
            }
        });
    }
}
