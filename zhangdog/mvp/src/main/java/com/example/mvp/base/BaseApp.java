package com.example.mvp.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseApp extends Application {
    public static Context mContext;
    public static SharedPreferences mSharedPreference;// File 数据库(SQLite) ContentProvider SP 网络存储(后台数据库MYsql,SQLServer，Oracale)
    public static HashMap<String, Object> map;
    public static List<Activity> mList;


    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        map = new HashMap<String, Object>();
        mSharedPreference = getSharedPreferences("config", MODE_PRIVATE);
        mList = new ArrayList<Activity>();
    }


    public static Context getContext() {
        return mContext;
    }

    public static SharedPreferences getSp() {
        if (mSharedPreference != null)
            return mSharedPreference;
        return null;
    }


    public static void exit() {
        //退出所有的Activtiy
        if (mList != null && mList.size() > 0) {
            for (Activity activity : mList) {
                activity.finish();
            }
        }
        //退出进程
        System.exit(0);
    }

    public static void clearActivtiys() {
        if (mList != null) {
            mList.clear();
            mList = null;
        }
    }


    public static void putObj(String key, Object object) {
        if (map != null)
            map.put(key, object);
    }


    public static Object getObj(String key) {
        if (map != null && map.size() > 0)
            return map.get(key);
        return null;
    }

    public static void clearMap() {
        if (map != null) {
            map.clear();
            map = null;
        }
    }


}
