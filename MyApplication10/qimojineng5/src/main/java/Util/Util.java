package Util;

import com.example.jiehe.dao.DaoMaster;
import com.example.jiehe.dao.DaoSession;
import com.example.jiehe.dao.FoodsDao;

import java.util.List;

import bean.Foods;
import greendaoappliction.GreenDaoAppliction;

public class Util {
    public static Util util;
    public FoodsDao foodsDao;

    public Util() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GreenDaoAppliction.getApp(), "ku.db");
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

    public boolean isHash(Foods foods) {
        List<Foods> list = foodsDao.queryBuilder().where(FoodsDao.Properties.Id.eq(foods.getId())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
}
