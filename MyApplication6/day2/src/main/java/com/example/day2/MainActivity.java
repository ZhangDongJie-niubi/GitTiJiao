package com.example.day2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    private String postUrl = "http://www.qubaobei.com/ios/cf/dish_list.php";
    /**
     * Get异步
     */
    private Button mGyi;
    /**
     * Get同步
     */
    private Button mGtong;
    /**
     * Post异步
     */
    private Button mPyi;
    /**
     * Post同步
     */
    private Button mPtong;
    /**
     * string请求体
     */
    private Button mStqing;
    /**
     * json请求体
     */
    private Button mJqing;
    /**
     * stream请求体
     */
    private Button mSqing;
    /**
     * 接口參數拼接
     */
    private Button mPing;
    /**
     * SmartRefreshLayout
     */
    private Button mSrl;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mGyi = (Button) findViewById(R.id.gyi);
        mGyi.setOnClickListener(this);
        mGtong = (Button) findViewById(R.id.gtong);
        mGtong.setOnClickListener(this);
        mPyi = (Button) findViewById(R.id.pyi);
        mPyi.setOnClickListener(this);
        mPtong = (Button) findViewById(R.id.ptong);
        mPtong.setOnClickListener(this);
        mStqing = (Button) findViewById(R.id.stqing);
        mStqing.setOnClickListener(this);
        mJqing = (Button) findViewById(R.id.jqing);
        mJqing.setOnClickListener(this);
        mSqing = (Button) findViewById(R.id.sqing);
        mSqing.setOnClickListener(this);
        mPing = (Button) findViewById(R.id.ping);
        mPing.setOnClickListener(this);
        mSrl = (Button) findViewById(R.id.srl);
        mSrl.setOnClickListener(this);
        mIv = (ImageView) findViewById(R.id.iv);
        mIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.gyi:
                OkHttpClient build = new OkHttpClient.Builder().build();
                Request build1 = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                Call call = build.newCall(build1);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
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
            case R.id.gtong:
                OkHttpClient build5 = new OkHttpClient.Builder().build();
                Request build6 = new Request.Builder()
                        .get()
                        .url(url)
                        .build();
                final Call call2 = build5.newCall(build6);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Response response = call2.execute();
                            String string = response.body().string();
                            final Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                                }
                            });

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case R.id.pyi:
                OkHttpClient build2 = new OkHttpClient.Builder().build();
                FormBody build3 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();
                Request build4 = new Request.Builder()
                        .post(build3)
                        .url(postUrl)
                        .build();
                Call call1 = build2.newCall(build4);
                call1.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        final Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;
            case R.id.ptong:

                break;
            case R.id.stqing:
                OkHttpClient build7 = new OkHttpClient.Builder().build();
                MediaType parse = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
                final String content = "stage_id=1&limit=20&page=1";
                final RequestBody requestBody = RequestBody.create(parse, content);
                Request build8 = new Request.Builder()
                        .url(postUrl)
                        .post(requestBody)
                        .build();
                Call call3 = build7.newCall(build8);
                call3.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        final Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (food != null) {
                                    Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "数据为空", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                break;
            case R.id.jqing:
                OkHttpClient builder = new OkHttpClient.Builder().build();
                MediaType parse1 = MediaType.parse("application/json;charset=utf-8");
                Foods foods = new Foods();
                foods.setStage_id("1");
                foods.setLimit("20");
                foods.setPage("1");
                Gson gson = new Gson();
                final String s = gson.toJson(foods);
                RequestBody requestBody1 = RequestBody.create(parse1, s);
                Request build9 = new Request.Builder()
                        .url(postUrl)
                        .post(requestBody1)
                        .build();
                Call call4 = builder.newCall(build9);
                call4.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        final Food food = new GsonBuilder().serializeNulls().serializeNulls().create().fromJson(string, Food.class);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (food != null) {
                                    Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "数据为空", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                break;
            case R.id.sqing:
                OkHttpClient build10 = new OkHttpClient.Builder().build();
                final MediaType type = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
                final String content1 = "stage_id=1&limit=20&page=1";
                RequestBody requestBody2 = new RequestBody() {

                    @Override
                    public MediaType contentType() {
                        return type;
                    }

                    @Override
                    public void writeTo(BufferedSink sink) throws IOException {
                        sink.writeUtf8(content1);
                    }
                };
                Request build11 = new Request.Builder()
                        .post(requestBody2)
                        .url(postUrl)
                        .build();
                Call call5 = build10.newCall(build11);
                call5.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        Gson gson1 = new Gson();
                        final Food food = gson1.fromJson(string, Food.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (food != null) {
                                    Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "获取数据为空", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
                break;
            case R.id.ping:
                OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
                Request build12 = new Request.Builder()
                        .url(url)
                        .build();
                Call call6 = okHttpClient.newCall(build12);
                call6.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        Gson gson1 = new Gson();
                        final Food food = gson1.fromJson(string, Food.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String pic = food.getData().get(0).getPic();
                                Glide.with(MainActivity.this).load(pic).into(mIv);
                            }
                        });
                    }
                });
                break;
            case R.id.srl:

                break;
        }
    }
}
