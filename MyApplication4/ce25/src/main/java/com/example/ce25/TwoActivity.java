package com.example.ce25;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class TwoActivity extends AppCompatActivity {
    private Food food;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<Food.ResultsBean> results = (List<Food.ResultsBean>) msg.obj;
            Banner ba = findViewById(R.id.ba);
            ba.setImages(results);
            ba.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Food.ResultsBean path1 = (Food.ResultsBean) path;
                    Glide.with(TwoActivity.this).load(path1.getUrl()).into(imageView);
                }
            });
            ba.start();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);



        new Thread(new Runnable() {
            @Override
            public void run() {
                con();
            }
        }).start();
    }

    private void con() {
        try {
            URL url = new URL("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/5/1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                InputStream is = con.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int len = 0;
                byte[] bytes = new byte[1024 * 4];
                while ((len = is.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                String s = bos.toString();
                Gson gson = new Gson();
                Food food = gson.fromJson(s, Food.class);
                List<Food.ResultsBean> results = food.getResults();
                Message msg = new Message();
                msg.obj = results;
                handler.sendMessage(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
