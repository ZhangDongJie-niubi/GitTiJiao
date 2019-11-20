package com.example.ce1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Fragmenta extends Fragment {
    private String string = "https://www.wanandroid.com/project/list/1/json?cid=294";

    private Shi shi;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fore, null);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {

        add();
    }

    private void add() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient build = new OkHttpClient.Builder().build();
                Request build1 = new Request.Builder()
                        .url(string)
                        .get()
                        .build();
                Call call = build.newCall(build1);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string = response.body().string();
                        final Food food = new GsonBuilder().serializeNulls().create().fromJson(string, Food.class);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                RecyclerView rv = inflate.findViewById(R.id.rv);
                                rv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
                                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                                shi = new Shi(getActivity());
                                rv.setAdapter(shi);
                                List<Food.DataBean.DatasBean> datas = food.getData().getDatas();
                                shi.add(datas);
                            }
                        });
                    }
                });
            }
        }).start();
    }


}
