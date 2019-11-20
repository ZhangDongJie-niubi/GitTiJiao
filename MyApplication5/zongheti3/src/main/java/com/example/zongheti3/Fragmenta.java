package com.example.zongheti3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Fragmenta extends Fragment {
    private Shi1 shi1;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    List<Rec.DataBean.DatasBean> obj = (List<Rec.DataBean.DatasBean>) msg.obj;
                    shi1.recj(obj);
                    break;
                case 2:
                    List<Ban.DataBean> obj1 = (List<Ban.DataBean>) msg.obj;
                    shi1.banj(obj1);
                    break;
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.seven, container, false);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
//https://www.wanandroid.com/banner/json
        //https://wanandroid.com/article/listproject/0/json
        RecyclerView rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        shi1 = new Shi1(getActivity());
        rv.setAdapter(shi1);
        SmartRefreshLayout srl = inflate.findViewById(R.id.srl);
        srl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
        srl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

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

    private void band() {
        try {
            URL url = new URL("https://wanandroid.com/article/listproject/0/json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024 * 4];
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            String s = bos.toString();
            Gson gson = new Gson();
            Rec rec = gson.fromJson(s, Rec.class);
            List<Rec.DataBean.DatasBean> datas = rec.getData().getDatas();
            Message msg = new Message();
            msg.what = 1;
            msg.obj = datas;
            handler.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void recd() {
        try {
            URL url = new URL("https://www.wanandroid.com/banner/json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024 * 4];
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            String s = bos.toString();
            Gson gson = new Gson();
            Ban ban = gson.fromJson(s, Ban.class);
            List<Ban.DataBean> data = ban.getData();
            Message msg = new Message();
            msg.what = 2;
            msg.obj = data;
            handler.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}