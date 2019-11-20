package com.example.lianxi1234;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

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

    private RecyclerView rv;
    private List<Food.DataBean> data;
    private Recycleadpter recycleadpter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.two, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        rv = inflate.findViewById(R.id.rv);
        final SmartRefreshLayout sr = inflate.findViewById(R.id.sr);
        sr.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                inData();
                sr.finishLoadMore();
            }
        });
        sr.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                sr.finishRefresh();
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleadpter = new Recycleadpter(getContext());
        rv.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        rv.setAdapter(recycleadpter);
        recycleadpter.setOnClickListener(new Recycleadpter.OnClickListener() {
            @Override
            public void onClickListener(int position) {
                Food.DataBean dataBean = data.get(position);
                String pic = dataBean.getPic();
                String title = dataBean.getTitle();
                Intent intent = new Intent(getContext(), ForeActivity.class);
                intent.putExtra("pic",pic);
                intent.putExtra("title",title);
                startActivity(intent);
            }
        });
        inData();
    }

    private void inData() {
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
                                data = value.getData();
                                recycleadpter.jia(data);
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
