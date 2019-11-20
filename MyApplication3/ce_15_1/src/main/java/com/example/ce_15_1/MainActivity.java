package com.example.ce_15_1;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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
private String string="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
 private Handler handler;
 private ListView lv;
 private  Shi shi;
 private Food.DataBean dataBean;
 private int a;
 private   List<Food.DataBean> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
              Food food=(Food)msg.obj;
               data = food.getData();
                lv = findViewById(R.id.lv);
               shi = new Shi(MainActivity.this, data);
                Toolbar tb = findViewById(R.id.tb);
                tb.setTitle("ToolBar標題");
                setSupportActionBar(tb);
                registerForContextMenu(lv);
                lv.setAdapter(shi);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                         dataBean = data.get(position);
                        String pic = dataBean.getPic();
                        String title = dataBean.getTitle();
                        Intent intent = new Intent(MainActivity.this,TwoActivity.class);
                        intent.putExtra("pic",pic);
                        intent.putExtra("title",title);
                        startActivityForResult(intent,200);
                    }
                });
               lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                   @Override
                   public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                       a=position;
                       return false;
                   }
               });
                return false;
            }
        });
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
            URL url = new URL(string);
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
                bos.close();
                is.close();
                msg.obj=food;
                handler.sendMessage(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.aaa,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ooo:
                shi.shan(a);

                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        unregisterForContextMenu(lv);
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode==200&&resultCode==100) {
            String s = data.getStringExtra("s");
            dataBean.setTitle(s);
            shi.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
