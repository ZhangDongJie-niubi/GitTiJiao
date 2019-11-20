package com.example.qimojineng03;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiserver {
    String url = "http://gank.io/api/data/";

    @GET("福利/20/2")
    Observable<Food> get();
}
