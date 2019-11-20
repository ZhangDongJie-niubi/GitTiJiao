package com.example.ce23;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String s;
    private String s1;
    private String sz;
    private String s1z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Food food = new Food();
        food.setId(1);
        food.setName("    張三");
        food.setSex("    男");
        food.setId(2);
        food.setName("    張三");
        food.setSex("    男");
        food.setId(3);
        food.setName("    張三");
        food.setSex("     男");
        food.setId(4);
        food.setName("    張三");
        food.setSex("     男");
        food.setId(5);
        food.setName("     張三");
        food.setSex("       男");
        food.setId(6);
        food.setName("      張三");
        food.setSex("       男");
        food.setId(7);
        food.setName("     張三");
        food.setSex("       男");
        food.setId(8);
        food.setName("     張三");
        food.setSex("      男");
        food.setId(9);
        food.setName("    張三");
        food.setSex("     男");
        food.setId(10);
        food.setName("    張三");
        food.setSex("    男");

        Util.getUtil().insert(food);
        final EditText et = findViewById(R.id.et);
        final EditText et1 = findViewById(R.id.et1);
        Button but = findViewById(R.id.but);
        s = et.getText().toString();
        s1 = et1.getText().toString();

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et.length() == 11 && et1.length() > 6 && et1.length() < 11) {
                    Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "您輸入的手機號或密碼有誤，請重新輸入", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

