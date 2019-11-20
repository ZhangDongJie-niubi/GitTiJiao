package com.example.zongheti;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Fragmenta extends Fragment {

    private View inflate;
    private Shi2 shi2;
    private List<Rec.DataBean.DatasBean> datas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.seleven, null);
        init();
        return inflate;
    }

    private void init() {
        shi2 = new Shi2(getActivity());
        RecyclerView rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(shi2);
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        registerForContextMenu(rv);
        shi2.setOnClickListener(new Shi2.OnClickListener() {
            @Override
            public void onClickListener(int i) {
                Shu shu = new Shu(getActivity(), "ku.db", null, 1);
                Rec.DataBean.DatasBean datasBean = datas.get(i);
                shu.add(datasBean.getTitle(), datasBean.getChapterName(), datasBean.getEnvelopePic());
            }
        });
        add();
    }

    private void add() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                recd();
                band();
            }
        }).start();

    }

    //https://www.wanandroid.com/banner/json
    //https://wanandroid.com/article/listproject/0/json
    private void band() {
        OkHttpClient build = new OkHttpClient.Builder().build();
        Request build1 = new Request.Builder()
                .get()
                .url("https://www.wanandroid.com/banner/json")
                .build();
        Call call = build.newCall(build1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final Ban ban = new GsonBuilder().serializeNulls().create().fromJson(string, Ban.class);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        shi2.banj(ban.getData());
                    }
                });
            }
        });
    }

    private void recd() {
        OkHttpClient build = new OkHttpClient.Builder().build();
        Request build1 = new Request.Builder()
                .get()
                .url("https://wanandroid.com/article/listproject/0/json")
                .build();
        Call call = build.newCall(build1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final Rec rec = new GsonBuilder().serializeNulls().create().fromJson(string, Rec.class);
                getActivity().runOnUiThread(new Runnable() {


                    @Override
                    public void run() {
                        datas = rec.getData().getDatas();
                        shi2.recj(datas);
                    }
                });
            }
        });
    }

}
