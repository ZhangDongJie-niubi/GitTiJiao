package com.example.ce28_1_1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private boolean bool;
    private int a = 1;
    private String string = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=";
    Handler handler = new Handler(new Handler.Callback() {

        private Shi shi;

        @Override
        public boolean handleMessage(Message msg) {
            Food food = (Food) msg.obj;
            List<Food.DataBean> data = food.getData();
            ListView lv = findViewById(R.id.lv);
            shi = new Shi(data, MainActivity.this);
            lv.setAdapter(shi);
            lv.setOnScrollListener(new AbsListView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(AbsListView view, int scrollState) {

                    if (scrollState == SCROLL_STATE_IDLE && bool) {
                        a++;
                        conn();

                    }

                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount > 0) {
                        bool = true;
                    } else {
                        bool = false;
                    }
                }
            });
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conn();
    }

    private void conn() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                con();
            }
        }).start();
    }

    private void con() {
        try {
            URL url = new URL(string + a);
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
            Food food = gson.fromJson(s, Food.class);
            Message msg = new Message();
            msg.obj = food;
            handler.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
