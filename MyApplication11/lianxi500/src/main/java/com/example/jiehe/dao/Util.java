package com.example.jiehe.dao;

import com.example.lianxi500.bean.Foods;

import java.util.List;

public class Util {
    public static Util util;
    public FoodsDao foodsDao;


    public Util() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GreenDao.getapp(), "ku.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        foodsDao = daoSession.getFoodsDao();
    }

    public long insert(Foods foods) {
        if (!isHash(foods)) {
            long l = foodsDao.insertOrReplace(foods);
            return l;
        }
        return -1;
    }

    public List<Foods> cha() {
        List<Foods> foods = foodsDao.loadAll();
        return foods;
    }

    public static Util util() {
        if (util == null) {
            synchronized (Foods.class) {
                util = new Util();
            }
        }
        return util;
    }

    public boolean isHash(Foods foods) {
        List<Foods> list = foodsDao.queryBuilder().where(FoodsDao.Properties.Title.eq(foods.getTitle())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
}
