package peaster;

import java.util.List;

import bean.Food;
import modle.Asd;
import modle.Homemodle;
import view.HomeView;

public class Peaster implements Homemodle, HomePeaster {
    private HomeView homeView;
    private final Asd asd;

    public Peaster(HomeView homeView) {
        this.homeView = homeView;
        asd = new Asd();
    }

    @Override
    public void getchenggong(List<Food.DataBean.ListBean> list) {
        if (homeView != null) {
            homeView.getchenggong(list);
        }
    }

    @Override
    public void getData() {
        if (asd != null) {
            asd.getjieguo(this);
        }
    }
}
