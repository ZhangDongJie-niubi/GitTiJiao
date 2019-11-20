package com.example.ce17;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int a;
    private Shi shi;
    private List<Food.DataBean> data;
    String str = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    Handler handler = new Handler(new Handler.Callback() {




        @Override
        public boolean handleMessage(Message msg) {
            Food food = (Food) msg.obj;
            data = food.getData();
            RecyclerView rv = findViewById(R.id.rv);
            rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            shi = new Shi(MainActivity.this);
            rv.setAdapter(shi);
            shi.add(data);
            registerForContextMenu(rv);
            shi.setOnLongClickListener(new Shi.OnLongClickListener() {
                @Override
                public void onLongClickListener(int i) {
                    a=i;
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.aaa,menu);
    super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.one:
                List<Food.DataBean> list = shi.list;
                list.remove(a);
                shi.notifyDataSetChanged();
                break;
            case R.id.two:
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                List<Food.DataBean> list1 = shi.getList();
                Food.DataBean dataBean1 = list1.get(a);

                String pic = dataBean1.getPic();
                String title = dataBean1.getTitle();
                intent.putExtra("pic",pic);
                intent.putExtra("title",title);
                startActivity(intent);
                break;
        }
        return super.onContextItemSelected(item);
    }

    private String con() {
        try {
            URL url = new URL(str);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024 * 4];
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            String s = bos.toString();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void conn() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String string1 = con();
                Gson gson = new Gson();
                Food food = gson.fromJson(string1, Food.class);
                Message msg = new Message();
                msg.obj = food;
                handler.sendMessage(msg);
            }
        }).start();
    }
}
