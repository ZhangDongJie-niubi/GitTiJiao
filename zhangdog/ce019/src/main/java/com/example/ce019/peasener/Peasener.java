package com.example.ce019.peasener;

import com.example.ce019.bean.Food;
import com.example.ce019.model.Asd;
import com.example.ce019.model.Homemodel;
import com.example.ce019.view.Homeview;

import java.util.List;

public class Peasener implements Homepeasenter, Homemodel {
    private Homeview homeview;
    private final Asd asd;

    public Peasener(Homeview homeview) {
        this.homeview = homeview;
        asd = new Asd();
    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        if (homeview != null) {
            homeview.getchenggong(list);
        }
    }

    @Override
    public void getData() {
        if (asd != null) {
            asd.getjieguo(this);
        }
    }
}
