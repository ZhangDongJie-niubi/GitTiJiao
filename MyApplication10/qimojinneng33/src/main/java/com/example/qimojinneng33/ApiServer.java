package com.example.qimojinneng33;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url = "http://gank.io/api/data/";

    @GET("%E7%A6%8F%E5%88%A9/20/1")
    Observable<Food> get();
}
