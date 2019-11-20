package com.example.qimojinengbce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.List;

import com.example.mvpchouqu.adpter.Fuliapter;
import api.Apiserver;
import bean.Fuli;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class sevenActivity extends AppCompatActivity {
    private List<Fuli.ResultsBean> results;
    private ViewPager vp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);

        vp1 = findViewById(R.id.vp1);
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Apiserver.string)
                .build();
        Apiserver apiserver = build.create(Apiserver.class);
        Observable<Fuli> apiserver1 = apiserver.get1();
        apiserver1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Fuli>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Fuli value) {
                        results = value.getResults();
                        Fuliapter fuliapter = new Fuliapter(results, sevenActivity.this);
                        vp1.setAdapter(fuliapter);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
