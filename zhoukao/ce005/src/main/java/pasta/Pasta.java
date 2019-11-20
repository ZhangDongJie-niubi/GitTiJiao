package pasta;

import java.util.List;

import bean.Food;
import modle.Asd;
import modle.Homemodle;
import view.Homeview;

public class Pasta implements Homemodle, Homepasta {
    private Homeview homeview;
    private Asd asd;

    public Pasta(Homeview homeview) {
        this.homeview = homeview;
        asd = new Asd();
    }

    @Override
    public void getchenggong(List<Food.RecentBean> list) {
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
