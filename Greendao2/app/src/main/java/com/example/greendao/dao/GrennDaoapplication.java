package com.example.greendao.dao;

import android.app.Application;

public class GrennDaoapplication extends Application {
    public static GrennDaoapplication app;

    public GrennDaoapplication() {
        app = this;
    }

    public static GrennDaoapplication getApp() {
        return app;
    }

}
