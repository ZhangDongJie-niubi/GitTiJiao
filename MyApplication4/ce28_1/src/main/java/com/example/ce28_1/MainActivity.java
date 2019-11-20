package com.example.ce28_1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Food food = (Food) msg.obj;
            List<Food.DataBean> data = food.getData();
            Shi shi = new Shi(MainActivity.this, data);
            ListView lv = findViewById(R.id.lv);
            lv.setAdapter(shi);
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
       });
    }
    public void con() {
        try {

            URL url = new URL("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1");
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
