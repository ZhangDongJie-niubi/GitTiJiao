package com.example.zhangdog.paesta;

import com.example.zhangdog.bean.Food;
import com.example.zhangdog.model.Asd;
import com.example.zhangdog.model.Homemodel;
import com.example.zhangdog.view.HomeView;

import java.util.List;

public class Peasta implements Homemodel, Homepeasta {
    private HomeView homeView;
    private Asd asd;

    public Peasta(HomeView homeView) {
        this.homeView = homeView;
        asd = new Asd();
    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        if (homeView != null) {
            homeView.getchenggong(list);
        }
    }

    @Override
    public void getshibai(String shibai) {

    }

    @Override
    public void getData() {
        if (asd != null) {
            asd.jieguo(this);
        }
    }
}
