package com.example.a9_9zuoye1;

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

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Fragmentb extends Fragment {
    private Shi2 shi;
    private View inflate;
    private int id;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<Recc.DataBean.DatasBean> datasBeans = (List<Recc.DataBean.DatasBean>) msg.obj;
            RecyclerView rv = inflate.findViewById(R.id.rv);
            rv.setLayoutManager(new LinearLayoutManager(getActivity()));
            shi = new Shi2(datasBeans, getActivity());
            rv.setAdapter(shi);
        }
    };


    /*private String string = "wanandroid.com/article/listproject/0/json";*/


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.activitys_main, container, false);
        id = getArguments().getInt("name");
        add();
        return inflate;
    }

    //    获取tab标签接口：https://www.wanandroid.com/project/tree/json
//    各个tab下的列表接口：https://www.wanandroid.com/project/list/1/json?cid=312
    private void add() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    URL url = new URL("https://www.wanandroid.com/project/list/1/json?cid=" + id);
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
                    Recc recc = gson.fromJson(s, Recc.class);
                    List<Recc.DataBean.DatasBean> datas = recc.getData().getDatas();
                    Message msg = new Message();
                    msg.obj = datas;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
