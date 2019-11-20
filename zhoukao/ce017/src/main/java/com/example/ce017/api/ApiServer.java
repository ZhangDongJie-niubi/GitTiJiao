package com.example.ce017.api;

import com.example.ce017.bean.Food;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url = "https://api.yunxuekeji.cn/yunxue_app_api/content/getData/30/66597/1/";

    @GET("10")
    Observable<Food> get();
}
