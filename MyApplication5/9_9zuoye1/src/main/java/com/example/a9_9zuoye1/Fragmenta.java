package com.example.a9_9zuoye1;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Fragmenta extends Fragment {
    private Shi shi;
    private View inflate;
    private TabLayout tl;
    private ViewPager vp;
    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<Rec.DataBean.DatasBean> datas = (List<Rec.DataBean.DatasBean>) msg.obj;

            List<Fragment> arr = new ArrayList<>();
            vp = inflate.findViewById(R.id.vps);
            tl = inflate.findViewById(R.id.tls);
            for (Rec.DataBean.DatasBean datasBean : datas) {
                Fragmentb fragmentb = new Fragmentb();
                Bundle bundle = new Bundle();
                bundle.putInt("name", datasBean.getId());
                arr.add(fragmentb);
                fragmentb.setArguments(bundle);
                tl.addTab(tl.newTab().setText(datasBean.getChapterName()));
            }
            Shi1 shi1 = new Shi1(getChildFragmentManager(), arr);
            vp.setAdapter(shi1);
            tl.setupWithViewPager(vp);
            for (int i = 0; i < datas.size(); i++) {
                tl.getTabAt(i).setText(datas.get(i).getChapterName());
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fraga_layout, container, false);
        add();
        return inflate;
    }

    //    获取tab标签接口：https://www.wanandroid.com/project/tree/json
//
    //    各个tab下的列表接口：https://www.wanandroid.com/project/list/1/json?cid=312
    private void add() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    URL url = new URL("https://www.wanandroid.com/project/tree/json");
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
                    msg.obj = datas;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
