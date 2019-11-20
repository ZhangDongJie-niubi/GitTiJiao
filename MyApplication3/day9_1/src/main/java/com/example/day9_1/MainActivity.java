package com.example.day9_1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private Fragmenta fragmenta;
    private Fragmentb fragmentb;
    private RadioButton rb;
    private RadioButton rb1;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg = findViewById(R.id.bg);
        rb = findViewById(R.id.rb);
        rb1 = findViewById(R.id.rb1);
        LinearLayout ll = findViewById(R.id.lin);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb:
                            FragmentManager fm = getSupportFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.show(fragmenta).hide(fragmentb).commit();
                        break;
                    case R.id.rb1:
                        FragmentManager   fm1= getSupportFragmentManager();
                        FragmentTransaction ft1 = fm1.beginTransaction();
                        if (!fragmentb.isAdded()){
                            ft1.add(R.id.lin,fragmentb);
                        }

                        ft1.show(fragmentb).hide(fragmenta).commit();
                        break;


                }

            }
        });


        fragmenta = new Fragmenta();
        fragmentb = new Fragmentb();
        FragmentManager fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.lin, fragmenta);
        ft.commit();
    }
}
