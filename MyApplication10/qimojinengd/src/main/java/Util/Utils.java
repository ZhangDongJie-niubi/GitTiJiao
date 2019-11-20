package Util;

import com.example.jiehe.dao.DaoMaster;
import com.example.jiehe.dao.DaoSession;
import com.example.jiehe.dao.FoodsDao;

import java.util.List;

import Appliction.Grenndaoappliction;
import bean.Foods;

public class Utils {
    public static Utils utils;
    public FoodsDao foodsDao;

    public Utils() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(Grenndaoappliction.getApp(), "ku.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        foodsDao = daoSession.getFoodsDao();

    }

    public static Utils getutils() {
        if (utils == null) {
            synchronized (Utils.class) {
                utils = new Utils();
            }
        }
        return utils;
    }

    public long insert(Foods foods) {
        if (!isHash(foods)) {
            long l = foodsDao.insertOrReplace(foods);
            return l;
        }
        return -1;
    }

    public boolean delete(Foods foods) {
        if (isHash(foods)) {
            foodsDao.delete(foods);
            return true;
        }
        return false;
    }

    public boolean update(Foods foods) {
        if (isHash(foods)) {
            foodsDao.update(foods);
            return true;
        }
        return false;
    }

    public List<Foods> qurry(Foods foods) {
        List<Foods> foods1 = foodsDao.loadAll();
        return foods1;
    }

    public boolean isHash(Foods foods) {
        List<Foods> list = foodsDao.queryBuilder().where(FoodsDao.Properties.Id.eq(foods.getId())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
}
