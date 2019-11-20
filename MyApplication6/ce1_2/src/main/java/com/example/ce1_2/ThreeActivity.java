package com.example.ce1_2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ThreeActivity extends AppCompatActivity {
    private String string = "https://wanandroid.com/article/listproject/0/json";
    private String string1 = "https://www.wanandroid.com/banner/json";
    private Shi1 shi1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        RecyclerView rv = findViewById(R.id.rv);
        shi1 = new Shi1(ThreeActivity.this);
        rv.setAdapter(shi1);
        add();
    }

    private void add() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                addd();
                adddd();
            }


        }).start();
    }

    private void adddd() {
        OkHttpClient build = new OkHttpClient.Builder().build();
        Request build1 = new Request.Builder()
                .get()
                .url(string)
                .build();
        Call call = build.newCall(build1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final Rec rec = new GsonBuilder().serializeNulls().create().fromJson(string, Rec.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        List<Rec.DataBean.DatasBean> datas = rec.getData().getDatas();
                        shi1.recj(datas);
                    }
                });
            }
        });
    }

    private void addd() {
        OkHttpClient build2 = new OkHttpClient.Builder().build();
        Request build3 = new Request.Builder()
                .url(string1)
                .get()
                .build();
        Call call1 = build2.newCall(build3);
        call1.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final Ban ban = new GsonBuilder().serializeNulls().create().fromJson(string, Ban.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        List<Ban.DataBean> data = ban.getData();
                        shi1.banj(data);
                    }
                });
            }
        });
    }
}
