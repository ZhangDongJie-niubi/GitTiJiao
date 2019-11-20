package com.example.rxjava;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    //    //     String url = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
//
//    //    https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
//    String baseUrl = "http://www.qubaobei.com/ios/cf/";
//    String baseWelfareUrl = "https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/";
//
//    @GET("dish_list.php?stage_id=1&limit=20&page=1")
//    Call<ResponseBody> get1();
//
//    @GET("dish_list.php")
//    Call<ResponseBody> get2(@Query("stage_id") String stage_id, @Query("limit") String limit, @Query("page") String page);
//
//    @GET("ish_list.php")
//    Call<ResponseBody> get3(@QueryMap HashMap<String, String> map);
    String baseUrl = "http://www.qubaobei.com/ios/cf/";

    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Observable<Food> get();

}
