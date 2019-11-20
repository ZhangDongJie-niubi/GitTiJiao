package Api;

import bean.Food;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url = "https://www.wanandroid.com/project/list/";

    @GET("1/json?cid=294")
    Observable<Food> get();
}
