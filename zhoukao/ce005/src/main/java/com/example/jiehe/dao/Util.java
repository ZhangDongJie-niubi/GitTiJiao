package com.example.jiehe.dao;

import java.util.List;

import bean.Food;
import bean.Foods;

public class Util {
    private static Util util;
    private FoodsDao foodsDao;

    public Util() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GreenDao.getapp(), "ku.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        foodsDao = daoSession.getFoodsDao();
    }

    public static Util util() {
        if (util == null) {
            synchronized (Util.class) {
                util = new Util();
            }
        }
        return util;
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


    public boolean isHash(Foods foods) {
        List<Foods> list = foodsDao.queryBuilder().where(FoodsDao.Properties.Url.eq(foods.getUrl())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
}
