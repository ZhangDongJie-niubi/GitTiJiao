package jiehe;

import android.support.design.animation.AnimationUtils;

import api.ApiServer;
import bean.Food;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jiehe.Jiehemodle;
import modle.Homemodle;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Asd implements Jiehemodle {
    @Override
    public void getjieguo(final Homemodle homemodle) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiServer.url)
                .build();
        ApiServer server = build.create(ApiServer.class);
        Observable<Food> observable = server.get();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Food>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Food value) {
                        homemodle.getchenggong(value.getData().getDatas());
                    }

                    @Override
                    public void onError(Throwable e) {
                        homemodle.getshibai("网络请求失败" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
