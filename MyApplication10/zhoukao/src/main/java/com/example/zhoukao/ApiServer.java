package com.example.zhoukao;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiServer {
    String url = "http://www.qubaobei.com/ios/cf/";

    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Observable<Food> get();
    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Call<ResponseBody> get1();

    @POST("dish_list.php")
    @FormUrlEncoded
    Call<ResponseBody> post(@FieldMap HashMap<String, String> hashMap);

    @GET()
    Call<ResponseBody> get2(@Url String baseUrl, @QueryMap HashMap<String, String> hashMap);

    @GET("{page}")
    Call<ResponseBody> get3(@Path("page") String page, @QueryMap HashMap<String, String> hashMap);

    @POST("dish_list.php")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Call<ResponseBody> get4(@Body RequestBody requestBody);
}
