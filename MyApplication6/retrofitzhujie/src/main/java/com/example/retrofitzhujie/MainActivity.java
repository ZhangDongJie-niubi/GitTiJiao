package com.example.retrofitzhujie;

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
    private Button mBu5;
    /**
     * GET6
     */
    private Button mBut6;
    /**
     * POST7
     */
    private Button mBut7;
    /**
     * POST8
     */
    private Button mBut8;
    /**
     * POST9
     */
    private Button mBut9;
    /**
     * POST10
     */
    private Button mBut10;
    /**
     * POST11
     */
    private Button mBut11;
    /**
     * POST12
     */
    private Button mBut12;
    /**
     * POST13
     */
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
        mBu5 = (Button) findViewById(R.id.bu5);
        mBu5.setOnClickListener(this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.but1:
                get1();
                break;
            case R.id.but2:
                get2();
                break;
            case R.id.but3:
                get3();
                break;
            case R.id.but4:
                get4();
                break;
            case R.id.bu5:
                get5();
                break;
            case R.id.but6:
                get6();
                break;
            case R.id.but7:
                post7();
                break;
            case R.id.but8:
                post8();
                break;
            case R.id.but9:
                post9();
                break;
            case R.id.but10:
                post10();
                break;
            case R.id.but11:
                post11();
                break;
            case R.id.but12:
                post12();
                break;
            case R.id.but13:
                post13();
                break;
        }
    }

    private void get1() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        Call<ResponseBody> apiServer1 = apiServer.get1();
        apiServer1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String string = null;
                try {
                    string = response.body().string();
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

    private void get2() {
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

    private void get3() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        HashMap<String, String> arr = new HashMap<>();
        arr.put("stage_id", "1");
        arr.put("limit", "20");
        arr.put("page", "1");
        ApiServer apiServer = build.create(ApiServer.class);
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

    private void get4() {
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

    private void get5() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        HashMap<String, String> arr = new HashMap<>();
        arr.put("stage_id", "1");
        arr.put("limit", "20");
        arr.put("page", "1");
        Call<ResponseBody> apiServer5 = apiServer.get5("ish_list.php", arr);
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

    private void get6() {
    }

    private void post7() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        Call<ResponseBody> call = apiServer.post7("1", "20", "1");
        call.enqueue(new Callback<ResponseBody>() {
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

    private void post8() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        HashMap<String, String> arr = new HashMap<>();
        arr.put("stage_id", "1");
        arr.put("limit", "20");
        arr.put("page", "1");
        Call<ResponseBody> call = apiServer.post8(arr);
        call.enqueue(new Callback<ResponseBody>() {
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

    private void post9() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        FormBody build1 = new FormBody.Builder()
                .add("stage_id", "1")
                .add("limit", "20")
                .add("page", "1")
                .build();
        Call<ResponseBody> responseBodyCall = apiServer.post9(build1);
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

    private void post10() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.baseUrl).build();
        ApiServer apiServer = build.create(ApiServer.class);
        FormBody add = new FormBody.Builder()
                .add("stage_id", "1")
                .add("limit", "20")
                .add("page", "1")
                .build();
        Call<ResponseBody> responseBodyCall = apiServer.post10("ish_list.php", add);
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

    private void post11() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiServer.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer apiServer = build.create(ApiServer.class);
        Call<Food> foodCall = apiServer.post11("1", "20", "1");
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

    private void post12() {
    }

    private void post13() {
    }
}
