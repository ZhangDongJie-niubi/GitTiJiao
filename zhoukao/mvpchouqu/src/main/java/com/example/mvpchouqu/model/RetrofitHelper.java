package com.example.mvpchouqu.model;

import com.example.mvpchouqu.constant.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitHelper {
    private static RetrofitHelper retrofitHelper;
    private Retrofit retrofit;

    public RetrofitHelper() {
        initRetrofit();
    }

    private void initRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder().
                connectTimeout(15000, TimeUnit.MILLISECONDS)
                .readTimeout(8000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

    }

    public synchronized static RetrofitHelper getRetrofitHelper() {
        if (retrofitHelper == null) {
            synchronized (RetrofitHelper.class) {
                if (retrofitHelper == null)
                    retrofitHelper = new RetrofitHelper();
            }
        }
        return retrofitHelper;
    }

    public ApiServer getApiServer() {
        return retrofit.create(ApiServer.class);
    }
}
