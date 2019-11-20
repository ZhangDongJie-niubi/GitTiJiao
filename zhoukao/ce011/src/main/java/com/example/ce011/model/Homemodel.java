package com.example.ce011.model;

import com.example.ce011.bean.Food;

import java.util.List;

public interface Homemodel {
    void getchenggong(List<Food.DataBean.DatasBean> list);

    void getshibai(String shibai);
}