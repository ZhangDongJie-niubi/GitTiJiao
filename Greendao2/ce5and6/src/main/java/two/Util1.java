package two;

import java.util.List;

public class Util1 {

    private FoodDao foodDao;
    private static Util1 util1;

    private Util1() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GrennDao1.getApp(), "ku.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        foodDao = daoSession.getFoodDao();
    }

    public static Util1 getUtil1() {
        if (util1 == null) {
            synchronized (Util1.class) {
                util1 = new Util1();
            }
        }
        return util1;
    }

    public long insert(Food food) {
        if (!isHash(food)) {
            long l = foodDao.insertOrReplace(food);
            return l;
        }
        return -1;
    }

    public boolean delece(Food food) {
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

    public List<Food> list(Food food) {
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



















