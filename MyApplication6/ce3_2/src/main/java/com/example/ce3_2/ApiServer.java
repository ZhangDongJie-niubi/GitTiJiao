package com.example.ce3_2;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiServer {
    // String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    String baseUrl = "http://www.qubaobei.com/ios/cf/";

    @GET("dish_list.php")
    Call<ResponseBody> get(@QueryMap HashMap<String, String> map);
}
