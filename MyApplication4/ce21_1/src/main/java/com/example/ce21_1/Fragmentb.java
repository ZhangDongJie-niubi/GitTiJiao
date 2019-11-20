package com.example.ce21_1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import java.util.List;

public class Fragmentb extends Fragment {
    private View inflate;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Food food = (Food) msg.obj;
            List<Food.DataBean> data = food.getData();
            Shi1 shi1 = new Shi1(getActivity());
            RecyclerView rv = inflate.findViewById(R.id.rv);
            rv.setLayoutManager(new LinearLayoutManager(getActivity()));
            rv.setAdapter(shi1);
            shi1.add(data);
            return false;
        }
    });


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragmentb, container, false);
        add(inflate);
        return inflate;
    }

    public void add(View inflate) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    URL url = new URL("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    int responseCode = connection.getResponseCode();
                    if (responseCode == 200) {
                        InputStream is = connection.getInputStream();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int len = 0;
                        byte[] bytes = new byte[1024 * 4];
                        while ((len = is.read(bytes)) != -1) {
                            baos.write(bytes, 0, len);
                        }
                        Log.i("tag", baos.toString());
                        String s = baos.toString();
                        Gson gson = new Gson();
                        Food food = gson.fromJson(s, Food.class);
                        Message msg = new Message();
                        msg.obj = food;
                        handler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
