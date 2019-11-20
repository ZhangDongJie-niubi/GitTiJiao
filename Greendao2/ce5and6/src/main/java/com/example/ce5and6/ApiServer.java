package com.example.ce5and6;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServer {
    //    //
//
//    //    https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1
//    String baseUrl = "http://www.qubaobei.com/ios/cf/";
//    String baseWelfareUrl = "https://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/";
//
//    @GET("dish_list.php?stage_id=1&limit=20&page=1")
//    Call<ResponseBody> get1();
    String url = "http://www.qubaobei.com/ios/cf/";

    @GET("dish_list.php?stage_id=1&limit=20&page=1")
    Call<ResponseBody> get1();
}
