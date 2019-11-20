package com.example.qimojinengc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import bean.User;

public class TwoActivity extends AppCompatActivity {

    private ImageView iv;
    private String s1;
    private String s2;
    private EditText que;
    private Button zhuce;
    private EditText mi;
    private EditText zhang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        iv = findViewById(R.id.iv);
        zhang = findViewById(R.id.zhang);
        mi = findViewById(R.id.mi);
        que = findViewById(R.id.que);
        zhuce = findViewById(R.id.zhuce);


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, 1);
            }
        });
        zhuce.setOnClickListener(new View.OnClickListener() {

            private String s;

            @Override
            public void onClick(View view) {
                s1 = que.getText().toString();
                s2 = zhang.getText().toString();
                s = mi.getText().toString();
                if (!TextUtils.isEmpty(s2)) {
                    if (s.equals(s1)) {
                        User user = new User();
                        user.setName(s2);
                        user.setPass(s);
                        Util.util().insert(user);
                        Intent intent = new Intent(TwoActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(TwoActivity.this, "您输入的信息有误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //17631039812
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            Uri data1 = data.getData();
            iv.setImageURI(data1);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
