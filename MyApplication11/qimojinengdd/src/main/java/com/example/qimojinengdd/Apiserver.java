package com.example.qimojinengdd;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiserver {
    String url = "https://www.wanandroid.com/project/list/1/";

    @GET("json?cid=294")
    Observable<Food> get();
}
