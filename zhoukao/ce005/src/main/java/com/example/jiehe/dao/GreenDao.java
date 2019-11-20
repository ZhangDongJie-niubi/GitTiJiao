package com.example.jiehe.dao;

import android.app.Application;

public class GreenDao extends Application {
    private static GreenDao getapp;

    public GreenDao() {
        getapp = this;
    }

    public static GreenDao getapp() {
        return getapp;
    }
}
