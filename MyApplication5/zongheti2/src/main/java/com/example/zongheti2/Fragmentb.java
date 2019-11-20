package com.example.zongheti2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Fragmentb extends Fragment {
    private Shi3 shi3;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<Er.DataBean> obj = (List<Er.DataBean>) msg.obj;
            shi3.add(obj);
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.ten, container, false);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        ExpandableListView elv = inflate.findViewById(R.id.elv);
        shi3 = new Shi3(getActivity());
        elv.setAdapter(shi3);
        add();
    }

    private void add() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://www.wanandroid.com/tree/json");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    InputStream is = con.getInputStream();
                    int len=0;
                    byte[]bytes=new byte[1024*4];
                    while((len=is.read(bytes))!=-1){
                    bos.write(bytes,0,len);
                    }
                    String s = bos.toString();
                    Gson gson = new Gson();
                    Er er = gson.fromJson(s, Er.class);
                    List<Er.DataBean> data = er.getData();
                    Message msg = new Message();
                    msg.obj=data;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
