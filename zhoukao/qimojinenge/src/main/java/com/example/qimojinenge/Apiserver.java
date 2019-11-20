package com.example.qimojinenge;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiserver {
    String url = "https://www.wanandroid.com/project/tree/";

    @GET("json")
    Observable<Food> get();
}
