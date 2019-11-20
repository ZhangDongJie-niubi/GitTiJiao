package com.example.ce23;

import android.app.Application;

public class GrennDaoApplication extends Application {
    public static GrennDaoApplication app;

    public GrennDaoApplication() {
        app=this;
    }

    public static GrennDaoApplication getApp() {
        return app;
    }
}
//package com.example.greendao.dao;
//
//        import android.app.Application;
//
//public class GrennDaoapplication extends Application {
//    public static GrennDaoapplication app;
//
//    public GrennDaoapplication() {
//        app = this;
//    }
//
//    public static GrennDaoapplication getApp() {
//        return app;
//    }
//}
