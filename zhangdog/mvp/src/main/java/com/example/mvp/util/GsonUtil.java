package com.example.mvp.util;

import com.example.mvp.model.bean.FuliInfo;
import com.google.gson.Gson;

public class GsonUtil<T> {
    //GSON解析工具类
    public T GsonParse(String jsonStr, Class<T> tClass) {
        Gson gson = new Gson();
        T t = gson.fromJson(jsonStr, tClass);
        return t;
    }

}
