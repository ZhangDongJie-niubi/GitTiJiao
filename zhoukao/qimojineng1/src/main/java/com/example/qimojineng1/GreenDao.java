package com.example.qimojineng1;

import android.app.Application;

public class GreenDao extends Application {
    public static GreenDao greenDao;

    public GreenDao() {
        greenDao=this;
    }

    public static GreenDao getapp(){
        return greenDao;
    }
}
