package view;

import java.util.List;

import bean.Ban;
import bean.Rec;

public interface Homeview {
    void getchenggong(List<Rec.ResultsBean> list);
    void getchenggong1(List<Ban>ban);
    void getshibai(String shibai);
}
