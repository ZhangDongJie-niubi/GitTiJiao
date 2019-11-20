package com.example.day4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class day4 extends AppCompatActivity implements View.OnClickListener {


    private Button mBut;
    private Button mBut1;
    private Button mBut2;
    private Button mBut3;
    private Button mBut4;
    private Button mBut5;
    private Button mBut6;
    private Button mBut7;
    private Button mBut8;
    private Button mBut9;
    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_day4);
        initView();


    }

    private void initView() {
        mBut = (Button) findViewById(R.id.but);
        mBut.setOnClickListener(this);
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.but:
                butd();
                break;
            case R.id.but1:
                but1d();
                break;
            case R.id.but2:
                but2d();
                break;
            case R.id.but3:
                but3d();
                break;
            case R.id.but4:
                but4d();
                break;
            case R.id.but5:
                but5d();
                break;
            case R.id.but6:
                but6d();
                break;
            case R.id.but7:
                but7d();
                break;
            case R.id.but8:
                but8d();
                break;
            case R.id.but9:
                but9d();
                break;
        }
    }


    private void butd() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Call<ResponseBody> call1 = apiServer.get1();
        call1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    List<Food.DataBean> data = food.getData();
                    Toast.makeText(day4.this, data.get(0).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("TAG", t.getMessage());
            }
        });
    }

    private void but1d() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Call<ResponseBody> apiServer2 = apiServer.get2("1", "20", "1");
        apiServer2.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(day4.this, food.getData().get(1).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void but2d() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
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
                    Toast.makeText(day4.this, food.getData().get(2).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void but3d() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        HashMap<String, String> arr = new HashMap<>();
        arr.put("stage_id", "1");
        arr.put("limit", "20");
        arr.put("page", "1");
        Call<ResponseBody> apiServer4 = apiServer.get4("dish_list.php", arr);
        apiServer4.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(day4.this, food.getData().get(3).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void but4d() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
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
                    Toast.makeText(day4.this, food.getData().get(4).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void but5d() {
        page++;
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.url).build();
        ApiServer apiServer = build.create(ApiServer.class);
        Call<ResponseBody> apiServer6 = apiServer.get6(page);
        apiServer6.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Fuli fuli = new GsonBuilder().serializeNulls().create().fromJson(string, Fuli.class);
                    ImageView iv = findViewById(R.id.iv);
                    Glide.with(day4.this).load(fuli.getResults().get(page).getUrl()).into(iv);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void but6d() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.BASE_URL).build();
        ApiServer apiServer = build.create(ApiServer.class);
        Call<ResponseBody> post = apiServer.post("1", "20", "1");
        post.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(day4.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void but7d() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.BASE_URL).build();
        ApiServer apiServer = build.create(ApiServer.class);
        HashMap<String, String> arr = new HashMap<>();
        arr.put("stage_id", "1");
        arr.put("limit", "20");
        arr.put("page", "1");
        Call<ResponseBody> responseBodyCall = apiServer.post1(arr);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(day4.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    private void but8d() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.BASE_URL).build();
        ApiServer apiServer = build.create(ApiServer.class);
        FormBody formBody = new FormBody.Builder()
                .add("stage_id", "1")
                .add("limit", "20")
                .add("page", "1")
                .build();
        Call<ResponseBody> responseBodyCall = apiServer.post2(formBody);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                    Toast.makeText(day4.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void but9d() {
        Retrofit build = new Retrofit.Builder().baseUrl(ApiServer.BASE_URL).build();
        ApiServer apiServer = build.create(ApiServer.class);
        FormBody formBody = new FormBody.Builder()
                .add("stage_id", "1")
                .add("limit", "20")
                .add("page", "1")
                .build();
        Call<ResponseBody> responseBodyCall = apiServer.post3("dish_list.php", formBody);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Food food = new Gson().fromJson(string, Food.class);
                    Toast.makeText(day4.this, food.getData().get(0).getTitle(), Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


}
