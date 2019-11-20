package com.example.mvpchouqu.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseApp extends Application {
    public static Context context;
    public static HashMap<String, Object> map;
    public static SharedPreferences sp;
    public static List<Activity> list;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
        map = new HashMap<String, Object>();
        sp = getSharedPreferences("config", MODE_PRIVATE);
        list = new ArrayList<Activity>();
    }

    public static Context getContext() {
        return context;
    }

    public static SharedPreferences getsp() {
        if (sp != null)
            return sp;
        return null;
    }

    public static void exit() {
        if (list != null && list.size() > 0) {
            for (Activity activity : list) {
                activity.finish();
            }
        }
        System.exit(0);
    }

    public static void clearActivitys() {
        if (list != null) {
            list.clear();
            list = null;
        }
    }

    public static void putObj(String key, Object object) {
        if (map != null) {
            map.put(key, object);
        }
    }

    public static void getObj(String key) {
        if (map != null && map.size() > 0) {
            map.get(key);
        }
    }

    public static void clearmap() {
        if (map != null) {
            map.clear();
            map = null;
        }
    }
}
