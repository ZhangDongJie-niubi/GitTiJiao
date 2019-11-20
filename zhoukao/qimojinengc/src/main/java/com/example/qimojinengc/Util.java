package com.example.qimojinengc;

import com.example.jiehe.dao.DaoMaster;
import com.example.jiehe.dao.DaoSession;
import com.example.jiehe.dao.GreenDao;
import com.example.jiehe.dao.UserDao;

import java.util.List;

import bean.User;

public class Util {
public static Util util;
private UserDao userDao;


public Util() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GreenDao.getapp(), "ku.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
        }

public static Util util() {
        if (util== null) {
synchronized (Util.class) {
        util = new Util();
        }
        }
        return util;
        }


public long insert(User user) {
        if (!isHash(user)) {
        long l = userDao.insertOrReplace(user);
        return l;
        }
        return -1;
        }



public boolean delete(User user) {
        if (isHash(user)) {
        userDao.delete(user);
        return true;
        }
        return false;
        }

// 睡不着，在数羊的时候，突然有一只小羊站了出来，对我说“请你用心一点，你已经数过我一次了。”
public boolean updete(User user) {
        if (isHash(user)) {
        userDao.update(user);
        return true;
        }
        return false;
        }

public List<User> cha() {
        List<User> users = userDao.loadAll();
        return users;
        }

public boolean isHash(User user) {
        List<User> list = userDao.queryBuilder().where(UserDao.Properties.Name.eq(user.getName())).list();
        if (list.size() > 0) {
        return true;
        }
        return false;
        }
        }
