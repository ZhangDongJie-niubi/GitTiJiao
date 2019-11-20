package com.example.ce23;

import com.example.ce23.dao.DaoMaster;
import com.example.ce23.dao.DaoSession;
import com.example.ce23.dao.FoodDao;

import java.util.List;

public class Util {
    public static Util util;
    private final FoodDao foodDao;

    public Util() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GrennDaoApplication.getApp(), "ku.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        foodDao = daoSession.getFoodDao();
    }

    public static Util getUtil() {
        if (util == null) {
            util = new Util();
        }
        return util;
    }

    public boolean isHash(Food food) {
        List<Food> list = foodDao.queryBuilder().where(FoodDao.Properties.Name.eq(food.getName())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
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

    public List<Food> querry(Food food) {
        List<Food> foods = foodDao.loadAll();
        return foods;
    }
}
//    public List<Food> querry(Food food) {
//        List<Food> foods = foodDao.loadAll();
//        return foods;
//    }
//

//}