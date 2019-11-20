package com.example.qimojinengd.dao;

import android.app.Application;

public class GreenDao extends Application {
    public static GreenDao app;

    public GreenDao() {
        app = this;
    }

    public static GreenDao getapp() {
        return app;
    }
}
