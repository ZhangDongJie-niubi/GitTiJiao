package com.example.qimojineng1;

import com.example.jiehe.dao.DaoMaster;
import com.example.jiehe.dao.DaoSession;
import com.example.jiehe.dao.FoodDao;

import java.util.List;

public class Util {
    public static Util util;
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
            long insert = foodDao.insert(food);
            return insert;
        }
        return -1;
    }

    public List<Food> cha() {
        List<Food> foods = foodDao.loadAll();
        return foods;
    }


    public boolean isHash(Food food) {
        List<Food> list = foodDao.queryBuilder().where(FoodDao.Properties.Neirong.eq(food.getNeirong())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
}
