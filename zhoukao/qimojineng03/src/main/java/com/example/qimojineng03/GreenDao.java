package com.example.qimojineng03;

import android.app.Application;

public class GreenDao extends Application {
    public static GreenDao greenDao;

    public GreenDao() {
        greenDao = this;
    }

    public static GreenDao getapp() {
        return greenDao;
    }

}
