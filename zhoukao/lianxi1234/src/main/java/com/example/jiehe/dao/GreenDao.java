package com.example.jiehe.dao;

import android.app.Application;

public class GreenDao extends Application {
    private static GreenDao app;

    public GreenDao() {
        app = this;
    }

    public static GreenDao getapp() {
        return app;
    }
}
