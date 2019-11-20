package com.example.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class BaseApp extends Application {
    private static Context context;
    private static SharedPreferences sharedPreferences;
    private static HashMap<String, Object> map;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static Context getContext() {
        return context;
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public static void putO(String key, Object object) {
        if (map != null) {
            map.put(key, object);
        }
    }
    public static Object getObject(String key) {
        if (map != null && map.size() > 0)
            return map.get(key);
        return null;
    }
    public static void clearMap() {
        if (map != null) {
            map.clear();
            map=null;
        }
    }

}
