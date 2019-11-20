package com.example.ce019.api;

import com.example.ce019.bean.Food;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ApiServer {
    String url = "https://www.wanandroid.com/project/list/1/";

    @GET("json?cid=294")
    Observable<Food> get();
}
