package modle;

import java.util.List;

import api.Apiserver;
import bean.Ban;
import bean.Rec;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Asd implements Jiehe {

    @Override
    public void getjieguo(final Homemodle homemodle) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Apiserver.url)
                .build();
        Apiserver apiserver = build.create(Apiserver.class);
        Observable<Rec> recObservable = apiserver.get();
        recObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Rec>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Rec value) {
                        homemodle.getchenggong(value.getResults());
                    }

                    @Override
                    public void onError(Throwable e) {
                        homemodle.getshibai(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        Retrofit build1 = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Apiserver.url1)
                .build();
        Apiserver apiserver1 = build1.create(Apiserver.class);
        Observable<List<Ban>> apiserver11 = apiserver1.get1();
        apiserver11.observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Ban>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Ban> value) {
                        homemodle.getchenggong1(value);
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
