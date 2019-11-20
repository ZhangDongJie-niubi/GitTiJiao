package com.example.ce20;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

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

public class Fragmentzhuye extends Fragment {

    private Shi shi;
    private int a;
    private List<Ban.DataBean> data;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.two, null);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        shi = new Shi(getActivity());
        final RecyclerView rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(shi);
        registerForContextMenu(rv);
        add();
        final SmartRefreshLayout sl = inflate.findViewById(R.id.sl);
        sl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                add();
                sl.finishLoadMore();
            }
        });
         sl.setOnRefreshListener(new OnRefreshListener() {
             @Override
             public void onRefresh(@NonNull RefreshLayout refreshLayout) {
               data.clear();
                add();
                sl.finishRefresh();

             }
         });
        shi.setOnClickListener(new Shi.OnClickListener() {
            @Override
            public void onClickListener(int i) {
                a = i;
            }
        });
    }


    private void add() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiServer.recurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<Rec> rec = apiServer.rec();
        rec.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Rec>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Rec value) {
                        List<Rec.DataBean.DatasBean> datas = value.getData().getDatas();
                        shi.add(datas);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        Retrofit retrofit1 = new Retrofit.Builder().baseUrl(ApiServer.banurl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServer apiServer1 = retrofit1.create(ApiServer.class);
        Observable<Ban> rec1 = apiServer1.ban();
        rec1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Ban>() {



                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Ban value) {
                        data = value.getData();
                        shi.banadd(data);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(1, 1, 1, "刪除");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                shi.shan(a);
                break;
        }
        return super.onContextItemSelected(item);

    }
}
