package com.example.ce011.api;

import com.example.ce011.bean.Food;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url = "https://www.wanandroid.com/project/list/3/";

    @GET("json?cid=294")
    Observable<Food> get();
}
