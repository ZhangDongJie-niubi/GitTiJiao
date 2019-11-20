package com.example.day4_1;

import android.graphics.PostProcessor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * GET1
     */
    private Button mBut1;
    /**
     * GET2
     */
    private Button mBut2;
    /**
     * GET3
     */
    private Button mBut3;
    /**
     * GET4
     */
    private Button mBut4;
    /**
     * GET5
     */
    private Button mBut5;
    /**
     * GET6
     */
    private Button mBut6;
    /**
     * POST1
     */
    private Button mBut7;
    /**
     * POST2
     */
    private Button mBut8;
    /**
     * POST3
     */
    private Button mBut9;
    /**
     * POST4
     */
    private Button mBut0;
    private Button mBut11;
    private Button mBut12;
    private Button mBut13;

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
        mBut0 = (Button) findViewById(R.id.but0);
        mBut0.setOnClickListener(this);
        mBut11 = (Button) findViewById(R.id.but11);
        mBut11.setOnClickListener(this);
        mBut12 = (Button) findViewById(R.id.but12);
        mBut12.setOnClickListener(this);
        mBut13 = (Button) findViewById(R.id.but13);
        mBut13.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.but1:
                Get1();
                break;
            case R.id.but2:
                Get2();
                break;
            case R.id.but3:
                Get3();
                break;
            case R.id.but4:
                Get4();
                break;
            case R.id.but5:
                Get5();
                break;
            case R.id.but6:
                Get6();
                break;
            case R.id.but7:
                Post1();
                break;
            case R.id.but8:
                Post2();
                break;
            case R.id.but9:
                Post3();
                break;
            case R.id.but0:
                Post4();
                break;
            case R.id.but11:
                Post5();
                break;
            case R.id.but12:
                Post6();
                break;
            case R.id.but13:
                Post7();
                break;
        }
    }


    private void Get1() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Call<ResponseBody> apiServer1 = apiServer.get1();
        apiServer1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void Get2() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        Call<ResponseBody> apiServer2 = apiServer.get2("1", "20", "1");
        apiServer2.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(MainActivity.this, food.getData().get(1).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void Get3() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        HashMap<String, String> arr = new HashMap<>();
        arr.put("stage_id", "1");
        arr.put("limit", "20");
        arr.put("page", "1");
        Call<ResponseBody> apiServer3 = apiServer.get3(arr);
        apiServer3.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(MainActivity.this, food.getData().get(2).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void Get4() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        HashMap<String, String> arr = new HashMap<>();
        arr.put("stage_id", "1");
        arr.put("limit", "20");
        arr.put("page", "1");
        Call<ResponseBody> apiServer4 = apiServer.get4("ish_list.php", arr);
        apiServer4.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(MainActivity.this, food.getData().get(3).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void Get5() {

    }

    private void Get6() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        HashMap<String, String> arr = new HashMap<>();
        arr.put("stage_id", "1");
        arr.put("limit", "20");
        arr.put("page", "1");
        Call<ResponseBody> apiServer5 = apiServer.get5("dish_list.php", arr);
        apiServer5.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(MainActivity.this, food.getData().get(4).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void Post1() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        Call<ResponseBody> responseBodyCall = apiServer.post1("1", "20", "1");
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void Post2() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        HashMap<String, String> arr = new HashMap<>();
        arr.put("stage_id", "1");
        arr.put("limit", "20");
        arr.put("page", "1");
        Call<ResponseBody> apiServer5 = apiServer.get5("dish_list.php", arr);
        apiServer5.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void Post3() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        FormBody build1 = new FormBody.Builder()
                .add("stage_id", "1")
                .add("limit", "20")
                .add("page", "1")
                .build();
        Call<ResponseBody> responseBodyCall = apiServer.post3(build1);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void Post4() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        FormBody build1 = new FormBody.Builder()
                .add("stage_id", "1")
                .add("limit", "20")
                .add("page", "1")
                .build();
        Call<ResponseBody> responseBodyCall = apiServer.post4("dish_list.php", build1);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(MainActivity.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    private void Post5() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        final Call<ResponseBody> call = apiServer.post1("1", "20", "1");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<ResponseBody> execute = call.execute();
                    String string = execute.body().string();
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
    }

    private void Post6() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiServer.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer apiServer = build.create(ApiServer.class);
        Call<Food> foodCall = apiServer.post6("1", "20", "1");
        foodCall.enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                Food body = response.body();
                String title = body.getData().get(0).getTitle();
                Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {

            }
        });
    }

    private void Post7() {

    }

}
