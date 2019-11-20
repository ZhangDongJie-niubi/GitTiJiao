package api;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface Apiserver {
     String string = "https://gitee.com/Haoxueren/server/raw/master/images/";
     @GET("icon_android_300x331.jpg")
    Observable<ResponseBody>get();

}
