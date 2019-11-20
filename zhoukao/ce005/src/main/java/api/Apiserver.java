package api;

import bean.Food;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiserver {
    String url = "http://news-at.zhihu.com/api/4/news/";

    @GET("hot")
    Observable<Food> get();
}
