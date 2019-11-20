package com.example.day4;

import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiServer {
    //    private String url="http://apicloud.mob.com/appstore/health/search?key=1ac78a8602d58&name=转氨酶";
//    private String posturl="http://apicloud.mob.com/appstore/health/";

    //    String url = "http://apicloud.mob.com/appstore/health/search?key=1ac78a8602d58&name=转氨酶";
//    String BASE_URL = "http://apicloud.mob.com/appstore/health";
    String url = "https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/";
    String BASE_URL = "http://www.qubaobei.com/ios/cf/";

    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Call<ResponseBody> get1();

    @GET("dish_list.php")
    Call<ResponseBody> get2(@Query("stage_id") String stage_id, @Query("limit") String limit, @Query("page") String page);

    @GET("dish_list.php")
    Call<ResponseBody> get3(@QueryMap Map<String, String> map);

    @GET("{page}")
    Call<ResponseBody> get4(@Path("page") String page, @QueryMap HashMap<String, String> hashMap);

    @GET()
    Call<ResponseBody> get5(@Url String url, @QueryMap HashMap<String, String> hashMap);

    @GET("{page}")
    Call<ResponseBody> get6(@Path("page") int page);

    @POST("dish_list.php")
    @FormUrlEncoded
    Call<ResponseBody> post(@Field("stage_id") String stage_id, @Field("limit") String limit, @Field("page") String page);

    @POST("dish_list.php")
    @FormUrlEncoded
    Call<ResponseBody> post1(@FieldMap HashMap<String, String> map);

    @POST("dish_list.php")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Call<ResponseBody> post2(@Body RequestBody requestBody);

    @POST()
    @Headers("Content-Type:application/x-www-form-urlencoded")
    Call<ResponseBody> post3(@Url String url, @Body RequestBody requestBody);

}
