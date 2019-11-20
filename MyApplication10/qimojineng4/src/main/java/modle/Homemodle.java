package modle;

import java.util.List;

import bean.Ban;
import bean.Rec;

public interface Homemodle {
    void getchenggong(List<Rec.ResultsBean> list);
    void getchenggong1(List<Ban>ban);
    void getshibai(String shibai);
}
