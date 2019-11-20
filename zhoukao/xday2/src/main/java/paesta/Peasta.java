package paesta;

import java.util.List;

import bean.Food;
import modle.Homemodle;
import modle.Modle;
import view.Homeview;

public class Peasta implements Homepeasta, Homemodle {
    private Homeview homeview;
    private Modle modle;

    public Peasta(Homeview homeview) {
        this.homeview = homeview;
        modle = new Modle();
    }

    @Override
    public void getchenggong(List<Food.DataBean> list) {
        if (homeview != null) {
            homeview.getchenggong(list);
        }
    }

    @Override
    public void getshibai(String shibai) {
        if (homeview != null) {
            homeview.getshibai(shibai);
        }
    }

    @Override
    public void getData() {
        if (modle != null) {
            modle.getjieguo(this);
        }
    }
}
