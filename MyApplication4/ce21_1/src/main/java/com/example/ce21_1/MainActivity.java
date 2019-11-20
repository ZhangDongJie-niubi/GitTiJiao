package com.example.ce21_1;

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
        RadioGroup rg = findViewById(R.id.rg);
        Toolbar tb = findViewById(R.id.tb);
        tb.setTitle("ToolBar");
        setSupportActionBar(tb);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.ll, fragmenta);
        ft.commit();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.shou:
                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        /*ft.show(fragmenta).hide(fragmentb).commit();*/
                        if (fragmenta.isAdded()) {
                            ft.show(fragmenta);
                        } else {
                            ft.add(R.id.ll, fragmenta);
                        }
                        if (fragmentb.isAdded()) {
                            ft.hide(fragmentb);
                        }
                        ft.commit();
                        break;
                    case R.id.wo:
                        FragmentManager fm1 = getSupportFragmentManager();
                        FragmentTransaction ft1 = fm1.beginTransaction();
                        if (!fragmentb.isAdded()) {
                            ft1.add(R.id.ll, fragmentb);
                           /* ft1.show(fragmentb).hide(fragmenta).commit();*/
                        }else{
                            ft1.show(fragmentb);
                        }
                        if (fragmenta.isAdded()){
                            ft1.hide(fragmenta);
                        }
                        ft1.commit();
                        break;
                }
            }
        });

    }
}
