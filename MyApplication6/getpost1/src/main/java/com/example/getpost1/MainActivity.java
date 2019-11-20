package com.example.getpost1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Console;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    private String posturl = "https://www.qubaobei.com/ios/cf/dish_list.php?";
    /**
     * get启动
     */
    private Button mBut1;
    /**
     * post启动
     */
    private Button mBut2;
    /**
     * get启动
     */
    private Button mBut3;
    /**
     * post启动
     */
    private Button mBut4;
    /**
     * get启动
     */
    private Button mBut5;
    /**
     * post启动
     */
    private Button mBut6;
    /**
     * get启动
     */
    private Button mBut7;
    /**
     * post启动
     */
    private Button mBut8;
    /**
     * get启动
     */
    private Button mBut9;
    /**
     * post启动
     */
    private Button mBut10;
    /**
     * get启动
     */
    private Button mBut11;
    /**
     * post启动
     */
    private Button mBut12;
    /**
     * get启动
     */
    private Button mBut13;
    /**
     * post启动
     */
    private Button mBut14;
    /**
     * get启动
     */
    private Button mBut15;
    /**
     * post启动
     */
    private Button mBut16;
    /**
     * get启动
     */
    private Button mBut17;
    /**
     * post启动
     */
    private Button mBut18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBut1 = (Button) findViewById(R.id.but1);
        mBut1.setOnClickListener(this);
        mBut2 = (Button) findViewById(R.id.but2);
        mBut2.setOnClickListener(this);
        mBut3 = (Button) findViewById(R.id.but3);
        mBut3.setOnClickListener(this);
        mBut4 = (Button) findViewById(R.id.but4);
        mBut4.setOnClickListener(this);
        mBut5 = (Button) findViewById(R.id.but5);
        mBut5.setOnClickListener(this);
        mBut6 = (Button) findViewById(R.id.but6);
        mBut6.setOnClickListener(this);
        mBut7 = (Button) findViewById(R.id.but7);
        mBut7.setOnClickListener(this);
        mBut8 = (Button) findViewById(R.id.but8);
        mBut8.setOnClickListener(this);
        mBut9 = (Button) findViewById(R.id.but9);
        mBut9.setOnClickListener(this);
        mBut10 = (Button) findViewById(R.id.but10);
        mBut10.setOnClickListener(this);
        mBut11 = (Button) findViewById(R.id.but11);
        mBut11.setOnClickListener(this);
        mBut12 = (Button) findViewById(R.id.but12);
        mBut12.setOnClickListener(this);
        mBut13 = (Button) findViewById(R.id.but13);
        mBut13.setOnClickListener(this);
        mBut14 = (Button) findViewById(R.id.but14);
        mBut14.setOnClickListener(this);
        mBut15 = (Button) findViewById(R.id.but15);
        mBut15.setOnClickListener(this);
        mBut16 = (Button) findViewById(R.id.but16);
        mBut16.setOnClickListener(this);
        mBut17 = (Button) findViewById(R.id.but17);
        mBut17.setOnClickListener(this);
        mBut18 = (Button) findViewById(R.id.but18);
        mBut18.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.but1:
                OkHttpClient build = new OkHttpClient.Builder().build();
                Request builder = new Request.Builder()
                        .url(url)
                        .build();
                Call call = build.newCall(builder);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but2:
                OkHttpClient build1 = new OkHttpClient.Builder().build();
                FormBody builder1 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();
                Request builder2 = new Request.Builder()
                        .post(builder1)
                        .url(posturl)
                        .build();
                Call call1 = build1.newCall(builder2);
                call1.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but3:
                OkHttpClient build2 = new OkHttpClient.Builder().build();
                Request builder3 = new Request.Builder()
                        .get()
                        .url(url)
                        .build();
                Call call2 = build2.newCall(builder3);
                call2.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but4:
                OkHttpClient builder4 = new OkHttpClient.Builder().build();
                FormBody builder5 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();
                Request builder6 = new Request.Builder()
                        .post(builder5)
                        .url(posturl)
                        .build();
                Call call3 = builder4.newCall(builder6);
                call3.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but5:
                OkHttpClient build3 = new OkHttpClient.Builder().build();
                Request builder7 = new Request.Builder()
                        .get()
                        .url(url)
                        .build();
                Call call4 = build3.newCall(builder7);
                call4.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("LAG", e.getMessage());
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
            case R.id.but6:
                OkHttpClient builder8 = new OkHttpClient.Builder().build();
                FormBody builder10 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();
                Request builder9 = new Request.Builder()
                        .url(posturl)
                        .post(builder10)
                        .build();
                Call call5 = builder8.newCall(builder9);
                call5.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but7:
                OkHttpClient build4 = new OkHttpClient.Builder().build();
                Request builder11 = new Request.Builder()
                        .get()
                        .url(url)
                        .build();
                Call call6 = build4.newCall(builder11);
                call6.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but8:
                OkHttpClient build5 = new OkHttpClient.Builder().build();
                FormBody builder12 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();
                Request builder13 = new Request.Builder()
                        .post(builder12)
                        .url(posturl)
                        .build();
                Call call7 = build5.newCall(builder13);
                call7.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        final Food gson = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, gson.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                break;
            case R.id.but9:
                OkHttpClient build6 = new OkHttpClient.Builder().build();
                Request build7 = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                Call call8 = build6.newCall(build7);
                call8.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "onFailure: " + e.getMessage());
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
            case R.id.but10:
                OkHttpClient build8 = new OkHttpClient.Builder().build();
                FormBody build10 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();
                Request build9 = new Request.Builder()
                        .url(posturl)
                        .post(build10)
                        .build();
                Call call9 = build8.newCall(build9);
                call9.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but11:
                OkHttpClient build11 = new OkHttpClient.Builder().build();
                Request build12 = new Request.Builder()
                        .get()
                        .url(url)
                        .build();
                Call call10 = build11.newCall(build12);
                call10.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but12:
                OkHttpClient build13 = new OkHttpClient.Builder().build();
                FormBody build15 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();
                Request build14 = new Request.Builder()
                        .url(posturl)
                        .post(build15)
                        .build();
                Call call11 = build13.newCall(build14);
                call11.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but13:
                OkHttpClient build16 = new OkHttpClient.Builder().build();
                Request build17 = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                Call call12 = build16.newCall(build17);
                call12.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but14:
                OkHttpClient build18 = new OkHttpClient.Builder().build();
                FormBody build19 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();
                Request build20 = new Request.Builder()
                        .post(build19)
                        .url(posturl)
                        .build();
                Call call13 = build18.newCall(build20);
                call13.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but15:
                OkHttpClient build21 = new OkHttpClient.Builder().build();
                Request build22 = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                Call call14 = build21.newCall(build22);
                call14.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but16:
                OkHttpClient build23 = new OkHttpClient.Builder().build();
                FormBody build24 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();
                Request build25 = new Request.Builder()
                        .post(build24)
                        .url(posturl)
                        .build();
                Call call15 = build23.newCall(build25);
                call15.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but17:
                OkHttpClient build26 = new OkHttpClient.Builder().build();
                Request build27 = new Request.Builder()
                        .get()
                        .url(url)
                        .build();
                Call call16 = build26.newCall(build27);
                call16.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
            case R.id.but18:
                OkHttpClient build28 = new OkHttpClient.Builder().build();
                FormBody build29 = new FormBody.Builder()
                        .add("stage_id", "1")
                        .add("limit", "20")
                        .add("page", "1")
                        .build();
                Request build30 = new Request.Builder()
                        .url(posturl)
                        .post(build29)
                        .build();
                Call call17 = build28.newCall(build30);
                call17.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
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
        }
    }
}
