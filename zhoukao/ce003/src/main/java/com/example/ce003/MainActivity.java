package com.example.ce003;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //http://yun918.cn/study/public/index.php/register
        //http://yun918.cn/study/public/index.php/verify
        // http://yun918.cn/study/public/index.php/login
        EditText zhang = findViewById(R.id.zhang);
        EditText mi = findViewById(R.id.mi);
        Button deng = findViewById(R.id.deng);
        Button zhu = findViewById(R.id.zhu);
        zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });
    }
}
