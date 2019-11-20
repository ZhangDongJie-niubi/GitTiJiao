package com.example.qimojinengd.dao;

import java.util.List;

import bean.Daobean;

public class Util {
    public static Util util;
    private DaobeanDao daobeanDao;


    public Util() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GreenDao.getapp(), "ku.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        daobeanDao = daoSession.getDaobeanDao();
    }

    public static Util getUtil() {
        if (util == null) {
            synchronized (Util.class) {
                util = new Util();
            }
        }
        return util;
    }

    public long insert(Daobean daobean) {
        if (!isHash(daobean)) {
            long l = daobeanDao.insertOrReplace(daobean);
            return l;
        }
        return -1;
    }

    public boolean delete(Daobean daobean) {
        if (isHash(daobean)) {
            daobeanDao.delete(daobean);
            return true;
        }
        return false;
    }

    public boolean update(Daobean daobean) {
        if (isHash(daobean)) {
            daobeanDao.update(daobean);
            return true;
        }
        return false;
    }

    public List<Daobean> cha() {

        List<Daobean> daobeans = daobeanDao.loadAll();
        return daobeans;
    }

    public boolean isHash(Daobean daobean) {
        List<Daobean> list = daobeanDao.queryBuilder().where(DaobeanDao.Properties.Id.eq(daobean.getId())).list();
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
}
