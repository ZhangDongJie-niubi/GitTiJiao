package com.example.zhoumozuoye1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Fragmenta extends Fragment {
    private Shi1 shi1;
    private RecyclerView xrv;

    private int click;
    private List<Rec.DataBean.DatasBean> datasBean1s;
    @Nullable
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    datasBean1s = (List<Rec.DataBean.DatasBean>) msg.obj;
                    shi1.add(datasBean1s);
                    break;
                case 2:
                    List<Ban.DataBean> dataBean = (List<Ban.DataBean>) msg.obj;
                    shi1.lun(dataBean);
                    break;
            }

            super.handleMessage(msg);

        }
    };


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.nine, container, false);
        view(inflate);

        return inflate;
    }

    public void view(View inflate) {
        xrv = inflate.findViewById(R.id.recy);
        //設置管理器
        xrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        shi1 = new Shi1(getActivity());
        xrv.setAdapter(shi1);
        registerForContextMenu(xrv);
        shi1.setOnClickListener(new Shi1.OnClickListener() {
            @Override
            public void onClickListener(int i) {
                Intent intent = new Intent(getActivity(),FiveActivity.class);
                Rec.DataBean.DatasBean datasBean = datasBean1s.get(i);
                String link = datasBean.getLink();
                intent.putExtra("link",link);
                startActivity(intent);
            }
        });
        shi1.setOnLongClickListener(new Shi1.OnLongClickListener() {
            @Override
            public void onLongClickListener(int i) {
                click = i;
            }
        });
          iit();
    }

    public void iit() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                add();
                addd();
            }
        }).start();
    }

    private void add() {
        try {
                URL url = new URL("https://www.wanandroid.com/banner/json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader bu = new BufferedReader(new InputStreamReader(is));
            String str = "";
            StringBuffer buffer = new StringBuffer();
            while ((str = bu.readLine()) != null) {
                buffer.append(str);
            }
            String s = buffer.toString();
            Log.i("tag", s);
            Gson gson = new Gson();
            Ban ban = gson.fromJson(s, Ban.class);
            List<Ban.DataBean> data = ban.getData();
            Message message = new Message();
            message.what = 2;
            message.obj = data;
            handler.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addd() {
        try {
            URL url = new URL("https://wanandroid.com/article/listproject/0/json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader bu = new BufferedReader(new InputStreamReader(is));
            String str = "";
            StringBuffer buffer = new StringBuffer();
            while ((str = bu.readLine()) != null) {
                buffer.append(str);
            }
            Log.i("tag", buffer.toString());
            Gson gson = new Gson();
            Rec rec = gson.fromJson(buffer.toString(), Rec.class);
            List<Rec.DataBean.DatasBean> datas = rec.getData().getDatas();
            Message message = new Message();
            message.what = 1;
            message.obj = datas;
            handler.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(1, 1, 1, "刪除");
        menu.add(1, 2, 1, "收藏");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                shi1.delete(click);
                break;
            case 2:
                Rec.DataBean.DatasBean datasBean = datasBean1s.get(click);
                Shu shu = new Shu(getActivity(), "stus.db", null, 1);
                shu.Add(datasBean.getTitle(), datasBean.getChapterName());
                Toast.makeText(getActivity(), "收藏成功", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterForContextMenu(xrv);
    }
}
