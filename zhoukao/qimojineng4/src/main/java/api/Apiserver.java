package api;

import java.util.List;

import bean.Ban;
import bean.Rec;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiserver {
    String url = "https://gitee.com/Haoxueren/codes/rs928nybdtazkfc0igo6e39/";

    @GET("raw?blob_name=list_android")
    Observable<Rec> get();



    String url1 = "https://gitee.com/Haoxueren/codes/5h3p0q4y8sa6rlme2kunw73/";

    @GET("raw?blob_name=list_stars")
    Observable<List<Ban>> get1();

}