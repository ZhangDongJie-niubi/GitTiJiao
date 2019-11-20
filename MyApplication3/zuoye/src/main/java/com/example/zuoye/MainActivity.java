package com.example.zuoye;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

     Handler handler=new Handler(){
         @Override
         public void handleMessage(Message msg) {
             super.handleMessage(msg);
             if (msg.what==a){
                 Food food= (Food) msg.obj;
                 List<Food.DataBean> data = food.getData();
                 Shi shi = new Shi(MainActivity.this,data);
                 shi.add(data);
                 ListView listView = findViewById(R.id.lv);
                 listView.setAdapter(shi);
             }
         }
     };
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
                String string=con();
                Gson gson = new Gson();
                Food food = gson.fromJson(string, Food.class);
                Message msg = new Message();
                msg.obj=food;
                msg.what=a;
                handler.sendMessage(msg);
            }
        }).start();

    }

    public String con(){
        try {
            URL url = new URL("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int responseCode = con.getResponseCode();
            if (responseCode==200){
                InputStream is = con.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int len=0;
                byte[]bytes=new byte[1024*4];
                while((len=is.read(bytes))!=-1){
                    bos.write(bytes,0,len);
                }
                bos.close();
                is.close();
                return bos.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
