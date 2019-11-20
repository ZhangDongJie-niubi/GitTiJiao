package com.example.zhoukao;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = findViewById(R.id.vp);
        TabLayout tl = findViewById(R.id.tl);
        Toolbar tb = findViewById(R.id.tb);
        setSupportActionBar(tb);

        Feagmentb feagmentb = new Feagmentb();
        Fragmenta fragmenta = new Fragmenta();
        List<Fragment> arr = new ArrayList<>();
        arr.add(fragmenta);
        arr.add(feagmentb);

        Shi1 shi1 = new Shi1(getSupportFragmentManager(), arr);
        vp.setAdapter(shi1);

        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("首页");
        tl.getTabAt(1).setText("收藏");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "ok-get");
        menu.add(1, 2, 1, "ok-form表单");
        menu.add(1, 3, 1, "ok-stream");
        menu.add(1, 4, 1, "ok-string");
        menu.add(1, 5, 1, "ok-json");
        menu.add(1, 6, 1, "retrofit-get");
        menu.add(1, 7, 1, "retrofit-post");
        menu.add(1, 8, 1, "retrofit-url");
        menu.add(1, 9, 1, "retrofit-path");
        menu.add(1, 10, 1, "retrofit-body");
        return super.onCreateOptionsMenu(menu);
    }

//            2.ok-get（5分）
//            3.ok-form（5分）
//            4.ok-stream （5分）
//            5.ok-json（5分）
//            6.retrofit-get（5分）
//            7.retrofit-post（5分）
//            8.retrofit-url（5分）
//            9.retrofit-path（5分）
//            10.retrofit-body（5分）


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:

                OkHttpClient build = new OkHttpClient.Builder().build();
                Request build1 = new Request.Builder()
                        .get()
                        .url(url)
                        .build();
                Call call = build.newCall(build1);
                call.enqueue(new Callback() {
                    private Food food;

                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        food = new GsonBuilder().create().fromJson(string, Food.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
                break;
            case 2:
                //dish_list.php?stage_id=1&limit=20&page=1
                OkHttpClient build2 = new OkHttpClient.Builder().build();
                FormBody build3 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();
                Request build4 = new Request.Builder()
                        .post(build3)
                        .url(url)
                        .build();
                Call call1 = build2.newCall(build4);
                call1.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        final Food food = new GsonBuilder().create().fromJson(string, Food.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;
            case 3:
                OkHttpClient build5 = new OkHttpClient.Builder().build();
                final MediaType parse = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
                RequestBody requestBody = new RequestBody() {
                    @Override
                    public MediaType contentType() {
                        return parse;
                    }

                    @Override
                    public void writeTo(BufferedSink sink) throws IOException {
                      sink.writeUtf8("stage_id=1&limit=20&page=1");
                    }
                };
                Request build6 = new Request.Builder().post(requestBody).url(url).build();
                Call call2 = build5.newCall(build6);
                call2.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        final Food food = new GsonBuilder().create().fromJson(string, Food.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });
                break;

            case 5:
                OkHttpClient build7 = new OkHttpClient.Builder().build();
                PersonBean personBean = new PersonBean("1","20","1");
                String s = new Gson().toJson(personBean);
                MediaType parse1 = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
                RequestBody requestBody1 = RequestBody.create(parse1, s);
                Request build8 = new Request.Builder()
                        .post(requestBody1)
                        .url(url)
                        .build();
                Call call3 = build7.newCall(build8);
                call3.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        final Food food = new GsonBuilder().create().fromJson(string, Food.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;
            case 6:

                break;
            case 7:
                Retrofit build9 = new Retrofit.Builder().baseUrl(url).build();
                ApiServer apiServer = build9.create(ApiServer.class);
                HashMap<String, String> arr = new HashMap<>();
                arr.put("stage_id","1");
                arr.put("limit","20");
                arr.put("page","1");
                
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
