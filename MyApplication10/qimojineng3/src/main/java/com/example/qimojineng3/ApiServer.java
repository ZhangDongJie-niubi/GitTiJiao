package com.example.qimojineng3;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url = "http://gank.io/api/data/";

    @GET("福利/20/1")
    Observable<Food> get();
}
