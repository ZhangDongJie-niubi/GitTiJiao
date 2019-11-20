package com.example.jiehe.dao;

import com.example.ce009.Food;

import java.util.List;

public class Util {
    private static Util util;
    private FoodDao foodDao;

    public Util() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GreenDao.getapp(), "ku.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        foodDao = daoSession.getFoodDao();

    }

    public static Util util() {
        if (util == null) {
            synchronized (Util.class) {
                util = new Util();
            }
        }
        return util;
    }

    public long insert(Food food) {
        if (!isHash(food)) {
            long l = foodDao.insertOrReplace(food);
            return l;
        }
        return -1;
    }

    public List<Food> cha() {
        List<Food> foods = foodDao.loadAll();
        return foods;
    }

    public boolean isHash(Food food) {
        List<Food> list = foodDao.queryBuilder().where(FoodDao.Properties.Desc.eq(food.getUrl())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
}
