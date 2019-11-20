package api;

import bean.Food;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url = "http://yun918.cn/ks/";

    @GET("jiekou.json")
    Observable<Food> get();
}
