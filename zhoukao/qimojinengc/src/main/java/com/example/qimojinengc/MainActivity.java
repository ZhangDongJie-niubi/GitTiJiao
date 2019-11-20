package com.example.qimojinengc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import bean.User;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et);
        et1 = findViewById(R.id.et1);
        Button but = findViewById(R.id.but);
        Button but1 = findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                List<User> cha = Util.util().cha();
                for (int i = 0; i < cha.size(); i++) {
                    user.setName(cha.get(i).getName());
                    user.setPass(cha.get(i).getPass());
                }

                String s = et.getText().toString();
                String s1 = et1.getText().toString();
                if (s.equals(user.getName()) && s1.equals(user.getPass())) {
                    Intent intent = new Intent(MainActivity.this, ThreeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "账号或密码输入错误", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
