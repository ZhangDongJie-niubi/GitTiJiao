package com.example.ce21_2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private Fragmenta fragmenta;
    private Fragmentb fragmentb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmenta = new Fragmenta();
        fragmentb = new Fragmentb();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.ll, fragmenta);
        ft.commit();
        Toolbar tb = findViewById(R.id.tb);
        tb.setTitle("ToolBar");
        setSupportActionBar(tb);
        RadioGroup rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.but:
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.show(fragmenta).hide(fragmentb).commit();
                        break;
                    case R.id.but1:
                        FragmentManager fm1 = getSupportFragmentManager();
                        FragmentTransaction ft1 = fm1.beginTransaction();
                        if (!fragmentb.isAdded()) {
                            ft1.add(R.id.ll, fragmentb);
                        }
                        ft1.show(fragmentb).hide(fragmenta).commit();
                        break;
                }

            }
        });
    }
}
