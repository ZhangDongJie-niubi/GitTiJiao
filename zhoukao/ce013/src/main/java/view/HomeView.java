package view;

import java.util.List;

import bean.Food;

public interface HomeView {
    void getchenggong(List<Food.DataBean.DatasBean> list);

    void geishibai(String shibai);
}
