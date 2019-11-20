package com.example.lianxi500.peater;

import com.example.lianxi500.bean.Food;
import com.example.lianxi500.modle.Asd;
import com.example.lianxi500.modle.Homemedle;
import com.example.lianxi500.view.Homeview;

import java.util.List;

public class Peater implements Homemedle, Homepeater {
    private Homeview homeview;
    private final Asd asd;

    public Peater(Homeview homeview) {
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
            asd.getJieguo(this);
        }
    }
}
