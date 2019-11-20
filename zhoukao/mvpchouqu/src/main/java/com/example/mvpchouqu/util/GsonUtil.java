package com.example.mvpchouqu.util;

import com.google.gson.Gson;

public class GsonUtil<T> {
    //Gson解析工具类
    public T Gsonparse(String jsonstr, Class<T> tClass) {
        Gson gson = new Gson();
        T t = gson.fromJson(jsonstr, tClass);
        return t;
    }
}
