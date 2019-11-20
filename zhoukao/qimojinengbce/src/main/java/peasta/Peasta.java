package peasta;

import java.util.List;

import bean.Food;
import modle.Asd;
import modle.Homemolde;
import view.Homeview;

public class Peasta implements Homemolde, Homepeasta {
    private Homeview homeview;
    private Asd asd;

    public Peasta(Homeview homeview) {
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
        if (homeview != null) {
            homeview.getshibai(shibai);
        }
    }

    @Override
    public void getData() {
        if (asd != null) {
            asd.getjieguo(this);
        }
    }
}
