package com.example.mvpchouqu.model;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiServer {
    @GET
    Observable<ResponseBody> getData(@Url String url);

    @POST
    Observable<ResponseBody> post(@Url String url);







    @GET
    Observable<ResponseBody> getData(@HeaderMap Map<String, Object> headers,
                                     @Url String url);

    @GET
    Observable<ResponseBody> getData(@HeaderMap Map<String, Object> headers,
                                     @Url String url, @QueryMap Map<String, Object> params);

    @GET
    Observable<ResponseBody> getData(@Url String url, @QueryMap Map<String, Object> params);




    @POST
    Observable<ResponseBody> postData(@Url String url,
                                      @FieldMap Map<String, Object> params);


    @POST
    Observable<ResponseBody> postData(@HeaderMap Map<String, Object> headers,
                                      @Url String url);


    @POST
    Observable<ResponseBody> postData(@HeaderMap Map<String, Object> headers,
                                      @Url String url, @FieldMap Map<String, Object> params);


    @POST
    Observable<ResponseBody> postData(@HeaderMap Map<String, Object> headers,
                                      @Url String url,
                                      @Body RequestBody body);


    //下载文件
    @GET
    @Streaming
    Observable<ResponseBody> downloadFile(@Url String url);


    //只是上传文件
    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Part MultipartBody.Part part);


    //带参数的上传文件
    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @FieldMap Map<String, Object> params,
                                        @Part MultipartBody.Part part);


    //多文件上传未带参数
    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url,
                                        @Part List<MultipartBody.Part> parts);


    //多文件上传带参数的
    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @FieldMap Map<String, Object> params,
                                        @Part List<MultipartBody.Part> parts);

}
