package view;

import java.util.List;

import bean.Food;

public interface Homeview {
    void getchenggong(List<Food.RecentBean> list);

    void getshibai(String shibai);
}
