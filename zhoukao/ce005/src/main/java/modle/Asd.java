package modle;

import api.Apiserver;
import bean.Food;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Asd implements Jiege {

    @Override
    public void getjieguo(final Homemodle homemodle) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Apiserver.url)
                .build();
        Apiserver apiserver = build.create(Apiserver.class);
        Observable<Food> foodObservable = apiserver.get();
        foodObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Food>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Food value) {
                        homemodle.getchenggong(value.getRecent());
                    }

                    @Override
                    public void onError(Throwable e) {
                        homemodle.getshibai(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
