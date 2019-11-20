package com.example.greendao.dao;

import com.example.greendao.Food;

import java.util.List;

public class DbUtil {
    public static DbUtil dbUtil;
    private FoodDao foodDao;
    public DbUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GrennDaoapplication.getApp(), "ku.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        foodDao = daoSession.getFoodDao();
    }

    public static DbUtil getDbUtil() {
        if (dbUtil == null) {
            synchronized (DbUtil.class) {
                dbUtil = new DbUtil();
            }
        }
        return dbUtil;
    }
    public long insert(Food food) {
        if (!isHash(food)) {
            long l = foodDao.insertOrReplace(food);
            return l;
        }
        return -1;
    }

    public boolean delecte(Food food) {
        if (isHash(food)) {
            foodDao.delete(food);
            return true;
        }
        return false;
    }

    public boolean update(Food food) {
        if (isHash(food)) {
            foodDao.update(food);
            return true;
        }
        return false;
    }

    public List<Food> querry() {
        List<Food> foods = foodDao.loadAll();
        return foods;
    }

    public boolean isHash(Food food) {
            List<Food> list = foodDao.queryBuilder().where(FoodDao.Properties.Name.eq(food.getName())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }


}
