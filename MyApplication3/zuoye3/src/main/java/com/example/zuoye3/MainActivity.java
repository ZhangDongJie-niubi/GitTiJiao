package com.example.zuoye3;

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
private int a=50;
private  Shi shi;
private String string="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=";
private  int b=1;
private Boolean bool;
List<Food.DataBean> data;
     Handler handler=new Handler(){
         @Override
         public void handleMessage(Message msg) {
             super.handleMessage(msg);
             if (msg.what==a){
                 Food food= (Food) msg.obj;
                 data = food.getData();
                 shi.add(data);
             }

         }
     };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         connn();
         conn();
    }
    public void conn(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String string=con();
                Gson gson = new Gson();
                Food food = gson.fromJson(string, Food.class);
                Message msg = new Message();
                msg.what=a;
                msg.obj=food;
                handler.sendMessage(msg);
            }
        }).start();

    }
    public String con() {
        try {
            URL url = new URL(string+b);
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
                bos.close();
                is.close();
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     return "";
    }
    public void connn(){
        shi = new Shi(this);
        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(shi);
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState==SCROLL_STATE_IDLE&&bool){
                    b++;
                    conn();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    if (firstVisibleItem+visibleItemCount==totalItemCount){
                        bool=true;
                    }else{
                        bool=false;
                    }
            }
        });
    }
}
