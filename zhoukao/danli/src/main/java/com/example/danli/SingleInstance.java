package com.example.danli;

public class SingleInstance {
    //懒汉式
//    private static SingleInstance singleInstance;
//
//    private SingleInstance() {
//
//    }
//
//    public synchronized static SingleInstance getSingleInstance() {
//        if (singleInstance == null) {
//            synchronized (SingleInstance.class) {
//                if (singleInstance == null)
//                    singleInstance = new SingleInstance();
//            }
//        }
//        return singleInstance;
//    }
    //饿汉式
    private static SingleInstance singleInstance = new SingleInstance();

    private SingleInstance() {

    }

    public static SingleInstance getInstance() {
        return singleInstance;
    }
}
