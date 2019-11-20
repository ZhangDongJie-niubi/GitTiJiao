package api;

import bean.Food;
import bean.Fuli;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiserver {
    String url = "https://www.wanandroid.com/project/list/";
    String string = "http://gank.io/api/data/";

    @GET("1/json?cid=294")
    Observable<Food> get();

    @GET("福利/10/3")
    Observable<Fuli> get1();
}
