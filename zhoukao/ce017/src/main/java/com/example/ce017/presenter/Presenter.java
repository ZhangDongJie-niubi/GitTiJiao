package com.example.ce017.presenter;

import com.example.ce017.bean.Food;
import com.example.ce017.model.Asd;
import com.example.ce017.model.Homemodel;
import com.example.ce017.view.Homeview;

import java.util.List;

public class Presenter implements Homemodel, Homepresenter {
    private Homeview homeview;
    private final Asd asd;

    public Presenter(Homeview homeview) {
        this.homeview = homeview;
        asd = new Asd();
    }

    @Override
    public void getchenggong(List<Food.BodyBean.ResultBean> list) {
        if (homeview != null) {
            homeview.getchenggong(list);
        }
    }

    @Override
    public void shibai(String shibai) {

    }

    @Override
    public void getData() {
        if (asd != null) {
            asd.jieguo(this);
        }
    }
}
