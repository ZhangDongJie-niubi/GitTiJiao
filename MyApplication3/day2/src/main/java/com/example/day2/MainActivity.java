package com.example.day2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private int a = 50;
    private String string="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=";
    private int b=1;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == a) {
                Food food = (Food) msg.obj;
                List<Food.DataBean> data = food.getData();
                 shi.intedata(data);
            }

        }




    };
    private Shi shi;
    private boolean bool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
             initview();
             add();

    }
     public void add(){
         new Thread(new Runnable() {
             @Override
             public void run() {
                 String netData = con();
                 Gson gson = new Gson();
                 Food food = gson.fromJson(netData, Food.class);
                 Message msg = new Message();
                 msg.obj = food;
                 msg.what = a;
                 handler.sendMessage(msg);
             }

         }).start();
     }
    public String con() {
        try {
            URL url = new URL(string+b);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            int responseCode = con.getResponseCode();
            if (responseCode == 200) {

                InputStream inputStream = con.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int len = 0;
                byte[] bytes = new byte[1024 * 4];

                while ((len = inputStream.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                    Log.i("tag", bos.toString());
                }
                bos.close();
                inputStream.close();
                return bos.toString();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    private void initview() {
        ListView lv = findViewById(R.id.lv);
        shi = new Shi(MainActivity.this);
        lv.setAdapter(shi);
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
             if (scrollState==SCROLL_STATE_IDLE&&bool){
                 b++;
                 add();
             }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
               if (firstVisibleItem+visibleItemCount==totalItemCount&&totalItemCount>0){
                 bool=true;
               }else{
                   bool=false;
               }
            }
        });

    }

}
