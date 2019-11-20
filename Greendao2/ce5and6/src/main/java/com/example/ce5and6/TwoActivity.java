package com.example.ce5and6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class TwoActivity extends AppCompatActivity {

    private Shu shu;
    private String[] split;
    private EditText et2;
    private String[] split1;
    private String s1;
    private EditText et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        shu = new Shu(this, "ku.db", null, 1);
        final EditText et = findViewById(R.id.et);
        Button but = findViewById(R.id.tian);


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = et.getText().toString();
                split = s.split(",");
                shu.add(Integer.valueOf(split[0]), split[1]);
            }
        });
        final Button cha = findViewById(R.id.cha);
        cha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Student> cha1 = shu.cha();
                EditText et1 = findViewById(R.id.et1);
                et1.setText(cha1 + "");
            }
        });
        et2 = findViewById(R.id.et2);
        Button shan = findViewById(R.id.shan);
        shan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = et2.getText().toString();
                shu.shan(Integer.parseInt(s1));
            }
        });
        Button xiu = findViewById(R.id.xiu);
        et3 = findViewById(R.id.et3);

        xiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = et3.getText().toString();
                split1 = s1.split(",");
                shu.xiu(Integer.parseInt(split1[0]), split1[1]);
            }
        });
        Button but1 = findViewById(R.id.tiao);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TwoActivity.this,ThreeActivity.class);
                startActivity(intent);
            }
        });
    }
}
