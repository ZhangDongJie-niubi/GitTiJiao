package com.example.mvp.model;

import com.example.mvp.R;


import java.io.File;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;


/**
 * 1.封装RetriftService中的方法
 * 2.把RxJava和RetrofitService中的方法结合起来
 */
public class RetrofitRequestImpl {

    //既没有请求头也没有请求的GET请求
    public void getData(String strUrl, Observer<ResponseBody> observer) {
        RetrofitHelper.getmHelper().getRetrofitService().getData(strUrl).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }


    public void getData(Map<String, Object> headers,
                        String strUrl, Observer<ResponseBody> observer) {
        //如果headers集合是空的 就意味着没有请求头，没有请求头的话就调用上面的getData()方法
        if (headers == null || headers.size() == 0)
            getData(strUrl, observer);
        else
            //有请求头的话就把请求头放入下面getData方法中
            RetrofitHelper.getmHelper().getRetrofitService().
                    getData(headers, strUrl).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(observer);
    }


    public void getData(String strUrl, Map<String, Object> params,
                        Observer<ResponseBody> observer) {
        //请求参数的集合是空的话 就意味着既没有请求头也没有请求体
        if (params == null || params.size() == 0) {
            getData(strUrl, observer);
        } else {
            RetrofitHelper.getmHelper().getRetrofitService().
                    getData(strUrl, params).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(observer);
        }
    }

    public void getData(Map<String, Object> headers,
                        String strUrl, Map<String, Object> params,
                        Observer<ResponseBody> observer) {
        //只有请求体
        if (headers == null || headers.size() == 0 && params != null) {
            getData(strUrl, params, observer);
            //既没有请求头也没有请求体 什么都没有的get请求
        } else if (headers == null || headers.size() == 0 && params == null || params.size() == 0) {
            getData(strUrl, observer);
            //只有请求头
        } else if (headers != null && headers.size() > 0 && params == null || params.size() == 0) {
            getData(headers, strUrl, observer);
            //既有请求头也有请求体
        } else {
            RetrofitHelper.getmHelper().getRetrofitService().
                    getData(headers, strUrl, params).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(observer);

        }

    }


    //单个文件上传
    public void uploadFile(String uoloadUrl, File file, Observer<ResponseBody> observer) {
        //1.要上传的文件的类型  2.要上传的File文件
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        //  后台根据 key名接收 file文件
        //上传文件的part  三个参数 1.和后台约定好的key  2.当前文件名称 3.要上传的requestBody
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RetrofitHelper.getmHelper().getRetrofitService().
                uploadFile(uoloadUrl, part).subscribeOn
                (Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }

    //文件下载
    public void downloadFile(String fileUrl, Observer<ResponseBody> observer) {
        RetrofitHelper.getmHelper().getRetrofitService().downloadFile(fileUrl).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }

    //以json串为参数的post请求
    public void postData(Map<String, Object> headers, String url, String jsonStr,
                         Observer<ResponseBody> observer) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonStr);
        RetrofitHelper.getmHelper().getRetrofitService().postData(headers, url, body).
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }


}
