package com.example.ce28_2;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    private Button but;
    private Button but1;
    private Button but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but = findViewById(R.id.but);
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.two, null);
                PopupWindow popupWindow = new PopupWindow(inflate,200,200);
                popupWindow.showAsDropDown(but,100,100);
            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.two, null);
                PopupWindow popupWindow = new PopupWindow(inflate,200,200);
                popupWindow.setAnimationStyle(R.style.pop_a);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAsDropDown(but1,300,300);

            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.two, null);
                PopupWindow popupWindow = new PopupWindow(inflate,200,200);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.setOutsideTouchable(true);
                background(0.5f);
                popupWindow.showAtLocation(getWindow().getDecorView(),Gravity.CENTER,0,0);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        background(1.0f);
                    }
                });

            }
        });
    }
    public void background(float a){
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha= a;
        getWindow().setAttributes(attributes);
    }
}
