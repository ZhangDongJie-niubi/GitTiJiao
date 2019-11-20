package com.example.mvp.model;

import com.example.mvp.constant.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

//Retrofit的管理类
public class RetrofitHelper {
    private static RetrofitHelper mHelper;
    private Retrofit mRetrofit;

    private RetrofitHelper() {
        initRetrofit();
    }

    private void initRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder().
                connectTimeout(15000,
                        TimeUnit.MILLISECONDS).
                readTimeout(8000, TimeUnit.MILLISECONDS).
                //错误重链机制
                        retryOnConnectionFailure(true).
                        build();
        mRetrofit =
                new Retrofit.Builder().
                        baseUrl(Constant.BASE_URL).
                        addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                        client(client).build();
    }

    public synchronized static RetrofitHelper getmHelper() {
        if (mHelper == null) {
            synchronized (RetrofitHelper.class) {
                if (mHelper == null)
                    mHelper = new RetrofitHelper();
            }
        }
        return mHelper;
    }


    //返回一个RetrofitService对象
    public RetriftService getRetrofitService() {
        return mRetrofit.create(RetriftService.class);
    }

}
