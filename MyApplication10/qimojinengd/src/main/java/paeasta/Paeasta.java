package paeasta;

import java.util.List;

import bean.Food;
import jiehe.Asd;
import jiehe.Jiehemodle;
import modle.Homemodle;
import view.Homeview;

public class Paeasta implements Homepaeasta, Homemodle {
    private Homeview homeview;
    private Asd asd;


    public Paeasta(Homeview homeview) {
        this.homeview = homeview;
        asd = new Asd();
    }


    @Override
    public void getData() {
        if (asd != null) {
            asd.getjieguo(this);
        }
    }

    @Override
    public void getchenggong(List<Food.DataBean.DatasBean> list) {
        if (homeview != null) {
            homeview.getcheng(list);
        }
    }

    @Override
    public void getshibai(String shibai) {
        if (homeview != null) {
            homeview.getshibai(shibai);
        }
    }
}
