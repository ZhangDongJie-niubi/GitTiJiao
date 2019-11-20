package paesta;

import java.util.List;

import bean.Food;
import com.example.ce017.model.Asd;
import com.example.ce017.model.Homemodel;
import view.HomeView;

public class Peasta implements HomePeasta, Homemodel {
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
    public void geishibai(String shibai) {

    }

    @Override
    public void getData() {
        if (asd != null) {
            asd.getjieguo(this);
        }
    }
}
