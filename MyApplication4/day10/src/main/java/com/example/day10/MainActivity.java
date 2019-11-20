package com.example.day10;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import java.util.List;

public class MainActivity extends AppCompatActivity {
Handler handler=new Handler(new Handler.Callback() {

    private List<Food.ResultsBean> results;

    @Override
    public boolean handleMessage(Message msg) {
        Food food= (Food) msg.obj;
        results = food.getResults();
        Banner ba = findViewById(R.id.ba);
        ba.setImages(results);
        ba.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Food.ResultsBean path1 = (Food.ResultsBean) path;
                Glide.with(MainActivity.this).load(((Food.ResultsBean) path).getUrl()).into(imageView);
            }
        });
        ba.start();
        return false;
    }
});
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            if (responseCode==200){
                InputStream is = con.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int len=0;
                byte[]bytes=new byte[1024*4];
                while ((len=is.read(bytes))!=-1){
                    bos.write(bytes,0,len);
                }
                String s = bos.toString();
                Gson gson = new Gson();
                Food food = gson.fromJson(s, Food.class);
                Message msg = new Message();
                msg.obj=food;
                 handler.sendMessage(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
