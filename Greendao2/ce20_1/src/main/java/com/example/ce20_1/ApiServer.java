package com.example.ce20_1;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url = "https://wanandroid.com/article/listproject/0/";

    @GET("json")
    Observable<Food> get();
}
