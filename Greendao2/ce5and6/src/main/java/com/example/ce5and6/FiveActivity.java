package com.example.ce5and6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import retrofit2.Retrofit;

public class FiveActivity extends AppCompatActivity {
private String string="https://www.wanandroid.com/project/list/1/json?cid=1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        ListView lv = findViewById(R.id.lv);
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.url).build();
        


    }
}
