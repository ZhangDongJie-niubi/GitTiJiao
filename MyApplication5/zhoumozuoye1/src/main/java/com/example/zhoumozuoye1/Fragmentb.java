package com.example.zhoumozuoye1;

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
    private ExpandableListView ex;
    private Shi3 shi3;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Er er= (Er) msg.obj;
            List<Er.DataBean> data = er.getData();
            shi3.addAll(data);
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.items_layout, null);
        ex = view.findViewById(R.id.ev);
        shi3 = new Shi3(getActivity());
        ex.setAdapter(shi3);
        init(view);
        return view;
    }

    private void init(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                initView();
            }
        }).start();
    }

    private void initView() {
        try {
            URL url = new URL("https://www.wanandroid.com/tree/json\n");
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
            Message msg = new Message();
            msg.obj=er;
            handler.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
