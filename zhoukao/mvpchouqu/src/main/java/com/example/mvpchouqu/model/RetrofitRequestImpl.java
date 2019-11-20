package com.example.mvpchouqu.model;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 1.封装RetriftService中的方法
 * 2.把RxJava和RetrofitService中的方法结合起来
 */
public class RetrofitRequestImpl {

    //既没有请求头也没有请求的GET请求
    public void getData(String url, Observer<ResponseBody> observable){
         RetrofitHelper.getRetrofitHelper().getApiServer().getData(url)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(observable);
    }


     public void getData(Map<String,Object>headers,
                         String strUrl,Observer<ResponseBody>observer){
         //如果headers集合是空的 就意味着没有请求头，没有请求头的话就调用上面的getData()方法
         if (headers==null||headers.size()>0){
             getData(strUrl,observer);
         }
     }





}
