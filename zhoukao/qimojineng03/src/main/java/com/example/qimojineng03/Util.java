package com.example.qimojineng03;

import com.example.jiehe.dao.DaoMaster;
import com.example.jiehe.dao.DaoSession;
import com.example.jiehe.dao.FoodsDao;

import java.util.List;

public class Util {
    public static Util util;
    private final FoodsDao foodsDao;

    public Util() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GreenDao.getapp(), "ku.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        foodsDao = daoSession.getFoodsDao();
    }

    public static Util getUtil() {
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
