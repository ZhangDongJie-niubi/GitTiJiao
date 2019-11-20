package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    private String posturl = "http://www.qubaobei.com/ios/cf/dish_list.php";
    /**
     * 启动
     */
    private Button mBut;
    private Button mBut1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mBut = (Button) findViewById(R.id.but);
        mBut.setOnClickListener(this);
        mBut1 = (Button) findViewById(R.id.but1);
        mBut1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but:
                OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
                FormBody builder1 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();

                Request builder = new Request.Builder()
                        .url(posturl)
                        .post(builder1)
                        .build();
                Call call = okHttpClient.newCall(builder);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "11111+:" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        final Food food1 = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, food1.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;

            case R.id.but1:
                OkHttpClient build = new OkHttpClient.Builder().build();
                Request request = new Request.Builder()
                        .get()
                        .url(url)
                        .build();
                Call call1 = build.newCall(request);
                call1.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "MainActivity onFailure()" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        Gson gson = new Gson();
                        final Food food = gson.fromJson(string, Food.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;
        }
    }
}
