package com.example.zongheti;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Fragmenta extends Fragment {
    private Shi1 shi;
    private int a;
    private List<Rec.DataBean.DatasBean> obj;
    Handler handler=new Handler(){



        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    obj = (List<Rec.DataBean.DatasBean>) msg.obj;
                      shi.rec(obj);
                    break;
                case 2:
                    List<Ban.DataBean> obj1 = (List<Ban.DataBean>) msg.obj;
                    shi.ban(obj1);
                    break;
            }
            super.handleMessage(msg);
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.seleven, container, false);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        shi = new Shi1(getActivity());
        RecyclerView rv = inflate.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(shi);
        registerForContextMenu(rv);
        shi.setOnClickListener(new Shi1.OnClickListener() {
            @Override
            public void onClickListener(int i) {
                a=i;
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
            URL url = new URL("https://www.wanandroid.com/banner/json");
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
            Ban ban = gson.fromJson(s, Ban.class);
            List<Ban.DataBean> data = ban.getData();
            Message msg = new Message();
            msg.what=2;
            msg.obj=data;
            handler.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void recd() {
        try {
            URL url = new URL("https://wanandroid.com/article/listproject/0/json");
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
            Rec rec = gson.fromJson(s, Rec.class);
            List<Rec.DataBean.DatasBean> datas = rec.getData().getDatas();
            Message msg = new Message();
            msg.what=1;
            msg.obj=datas;
            handler.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(1,1,1,"刪除");
        menu.add(1,2,1,"收藏");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                 shi.remove(a);
                break;
            case 2:
                Rec.DataBean.DatasBean datasBean = obj.get(a);
                String title = datasBean.getTitle();
                String chapterName = datasBean.getChapterName();
                Shu shu = new Shu(getActivity(),"ku.db",null,1);
                shu.add(title,chapterName);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
