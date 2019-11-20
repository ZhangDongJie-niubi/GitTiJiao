package com.example.qimojinengdd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qimojinengdd.dao.Util;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragmenta extends Fragment {
    private Recycleadpter recycleadpter;
    private List<Food.DataBean.DatasBean> datas;
    private int a;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fore, container, false);
        initView(inflate);
        return inflate;
    }


    private void initView(View inflate) {


        RecyclerView rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleadpter = new Recycleadpter(getContext());
        rv.setAdapter(recycleadpter);
        initData();
        recycleadpter.setOnLongClickListener(new Recycleadpter.OnLongClickListener() {
            @Override
            public void onLongClickListener(int position) {
                a = position;
            }
        });


    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                add();
            }


        }).start();
    }

    private void add() {
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
                    public void onNext(final Food value) {
                        getActivity().runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                datas = value.getData().getDatas();
                                recycleadpter.jia(datas);

                                Food.DataBean.DatasBean datasBean = datas.get(a);
                                String desc = datasBean.getDesc();
                                Foods foods = new Foods();
                                foods.setDesc(desc);
                                Util.util().insert(foods);


                            }
                        });

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
