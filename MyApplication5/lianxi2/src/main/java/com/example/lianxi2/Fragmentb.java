package com.example.lianxi2;

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
import java.util.List;

public class Fragmentb extends Fragment {
    private View inflate;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<Er.DataBean.DatasBean> obj = (List<Er.DataBean.DatasBean>) msg.obj;
            RecyclerView rv = inflate.findViewById(R.id.rv);
            rv.setLayoutManager(new LinearLayoutManager(getActivity()));
            Shi2 shi2 = new Shi2(getActivity());
            rv.setAdapter(shi2);
             shi2.add(obj);
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fore, container, false);
       add();
        return inflate;
    }

    private void add() {
        try {
            URL url = new URL("https://www.wanandroid.com/project/list/1/json?cid=312");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len=0;
            byte[]bytes=new byte[1024*4];
            while((len=is.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
            String s = bos.toString();
            Gson gson = new Gson();
            Er er = gson.fromJson(s, Er.class);
            List<Er.DataBean.DatasBean> datas = er.getData().getDatas();
            Message msg = new Message();
            msg.obj=datas;
            handler.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
