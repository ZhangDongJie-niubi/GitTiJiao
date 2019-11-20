package com.example.rxjavaandretifit;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url = "http://www.qubaobei.com/ios/cf/";

    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Observable<Food> get();
}
