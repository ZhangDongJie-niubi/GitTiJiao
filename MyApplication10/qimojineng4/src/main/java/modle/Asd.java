package modle;

import java.util.List;

import Api.ApiServer;
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

public class Asd implements jiehe {


    @Override
    public void getjieguo(final Homemodle homemodle) {
        Retrofit build = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiServer.url)
                .build();
        ApiServer apiServer = build.create(ApiServer.class);
        Observable<Rec> recObservable = apiServer.get();
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
                        homemodle.getshibai("網絡請求失敗" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        Retrofit build1 = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiServer.url1)
                .build();
        ApiServer apiServer1 = build1.create(ApiServer.class);
        Observable<List<Ban>> apiServer11 = apiServer1.get1();
        apiServer11.subscribeOn(Schedulers.io())
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
                        homemodle.getshibai("網絡請求失敗" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

