package com.example.ce20;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    //    https://www.wanandroid.com/banner/json
//    https://wanandroid.com/article/listproject/0/json
    String recurl = "https://wanandroid.com/article/listproject/0/";
    String banurl = "https://www.wanandroid.com/banner/";

    @GET("json")
    Observable<Rec> rec();

    @GET("json")
    Observable<Ban> ban();
}
