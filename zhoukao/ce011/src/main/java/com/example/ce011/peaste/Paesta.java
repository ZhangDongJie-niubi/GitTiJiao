package com.example.ce011.peaste;

import com.example.ce011.bean.Food;
import com.example.ce011.model.Asd;
import com.example.ce011.model.Homemodel;
import com.example.ce011.view.Homeview;

import java.util.List;

public class Paesta implements Homepaesta, Homemodel {
    private Homeview homeview;
    private Asd asd;

    public Paesta(Homeview homeview) {
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
    public void getshibai(String shibai) {

    }

    @Override
    public void getData() {
        if (asd != null) {
            asd.jieguo(this);
        }
    }
}
