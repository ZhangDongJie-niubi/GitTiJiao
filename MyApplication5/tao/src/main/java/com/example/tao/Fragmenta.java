package com.example.tao;

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

public class Fragmenta extends Fragment {
    private View inflate;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            List<Zong.DataBean> obj = (List<Zong.DataBean>) msg.obj;
            List<Fragment> arr = new ArrayList<>();
            TabLayout tl1 = inflate.findViewById(R.id.tl);
            ViewPager vp1 = inflate.findViewById(R.id.vp);
            for (Zong.DataBean dataBean : obj) {
                Fragmentb fragmentb = new Fragmentb();
                arr.add(fragmentb);

                String name = dataBean.getName();
                int id = dataBean.getId();

                Bundle bundle = new Bundle();
                bundle.putInt("name", id);

                fragmentb.setArguments(bundle);

                tl1.addTab(tl1.newTab().setText(name));
                //tl1.addTab(tl1.newTab().setText(name));
            }
            Shi2 shi2 = new Shi2(getChildFragmentManager(), arr);
            vp1.setAdapter(shi2);
            tl1.setupWithViewPager(vp1);
            for (int i = 0; i < obj.size(); i++) {
                tl1.getTabAt(i).setText(obj.get(i).getName());
            }

            super.handleMessage(msg);

        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.two, container, false);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        View inflate1 = LayoutInflater.from(getActivity()).inflate(R.layout.three, null);
        RecyclerView rv = inflate1.findViewById(R.id.rv);
        Shi shi = new Shi(getActivity());
        rv.setAdapter(shi);
        add();
    }

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
                    Zong rec = gson.fromJson(s, Zong.class);
                    List<Zong.DataBean> data = rec.getData();
                    Message msg = new Message();
                    msg.obj = data;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
