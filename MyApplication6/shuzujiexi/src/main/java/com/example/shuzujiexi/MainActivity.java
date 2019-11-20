package com.example.shuzujiexi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    String url = "https://gitee.com/AnDrFly/anfly/raw/master/test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient build = new OkHttpClient.Builder().build();
        Request build1 = new Request.Builder()
                .get()
                .url(url)
                .build();

        Call call = build.newCall(build1);
        call.enqueue(new Callback() {

            private List<Food> o;

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                Type type = new TypeToken<List<Food>>() {
                }.getType();
                o = gson.fromJson(string, type);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Shi shi = new Shi(o, MainActivity.this);
                        ListView lv = findViewById(R.id.lv);
                        lv.setAdapter(shi);
                    }
                });
            }
        });
    }
}
