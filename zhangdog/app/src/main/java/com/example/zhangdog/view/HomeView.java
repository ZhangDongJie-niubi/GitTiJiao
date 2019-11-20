package com.example.zhangdog.view;

import com.example.zhangdog.bean.Food;

import java.util.List;

public interface HomeView {
    void getchenggong(List<Food.DataBean.DatasBean> list);

    void getshibai(String shibai);
}
