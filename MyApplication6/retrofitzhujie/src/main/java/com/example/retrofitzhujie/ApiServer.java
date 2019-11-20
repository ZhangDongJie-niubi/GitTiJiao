package com.example.retrofitzhujie;

import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiServer {
    //     String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";

    //    https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
    String baseUrl = "http://www.qubaobei.com/ios/cf/";
    String baseWelfareUrl = "https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/";

    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Call<ResponseBody> get1();

    @GET("dish_list.php")
    Call<ResponseBody> get2(@Query("stage_id") String stage_id, @Query("limit") String limit, @Query("page") String page);

    @GET("dish_list.php")
    Call<ResponseBody> get3(@QueryMap HashMap<String, String> map);

    @GET("{page}")
    Call<ResponseBody> get4(@Path("page") String page, @QueryMap HashMap<String, String> map);

    @GET()
    Call<ResponseBody> get5(@Url String url, @QueryMap HashMap<String, String> map);

    @POST("dish_list.php")
    @FormUrlEncoded
    Call<ResponseBody> post7(@Field("stage_id") String stage_id, @Field("limit") String limit, @Field("page") String page);

    @POST("dish_list.php")
    @FormUrlEncoded
    Call<ResponseBody> post8(@FieldMap HashMap<String, String> map);

    @POST("dish_list.php")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Call<ResponseBody> post9(@Body RequestBody requestBody);

    @POST("dish_list.php")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Call<ResponseBody> post10(@Url String url, @Body RequestBody requestBody);

    @POST("dish_list.php")
    @FormUrlEncoded
    Call<Food> post11(@Field("stage_id") String stage_id, @Field("limit") String limit, @Field("page") String page);
}
