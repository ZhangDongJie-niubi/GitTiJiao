package com.example.jiehe.dao;

import android.app.Application;

public class GreenDao extends Application {
    private static GreenDao greenDao;

    public GreenDao() {
        greenDao = this;
    }

    public static GreenDao getapp() {
        return greenDao;
    }
}
