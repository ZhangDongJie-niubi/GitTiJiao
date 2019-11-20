package com.example.ce15;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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

public class TwoActivity extends AppCompatActivity {
    private int a;
    private Shi shi;
    private List<Food.DataBean> data;
    private Food.DataBean dataBean;
    private Food.DataBean dataBean1;
   Handler handler=new Handler(new Handler.Callback() {



       @Override
       public boolean handleMessage(Message msg) {
           Food food= (Food) msg.obj;
           data = food.getData();
           shi = new Shi(TwoActivity.this);
           RecyclerView rv = findViewById(R.id.rv);
           rv.setLayoutManager(new LinearLayoutManager(TwoActivity.this));
           rv.setAdapter(shi);
           shi.add(data);
           shi.setOnLongClickListener(new Shi.OnLongClickListener() {
               @Override
               public void onLongClickListener(int i) {
                 a=i;
               }
           });
           registerForContextMenu(rv);
           shi.setOnClickListener(new Shi.OnClickListener() {



               @Override
               public void onClickListener(int i) {
                   Intent intent = new Intent(TwoActivity.this,ThreeActivity.class);
                   List<Food.DataBean> list = shi.getList();
                   dataBean1 = list.get(i);
                   String title = dataBean1.getTitle();
                   String pic =  dataBean1.getPic();
                   intent.putExtra("pic",pic);
                   intent.putExtra("title",title);
                   startActivityForResult(intent,200);
               }
           });
           return false;
       }
   });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Toolbar tb = findViewById(R.id.tb);
        tb.setTitle("ToolBar標題");
        setSupportActionBar(tb);
        new Thread(new Runnable() {
            @Override
            public void run() {
                con();
            }


        }).start();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.aaa,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.two:
                 data.remove(a);
                 shi.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==200&&resultCode==100){
            String s = data.getStringExtra("s");
           dataBean1.setTitle(s);
           shi.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void con() {
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
