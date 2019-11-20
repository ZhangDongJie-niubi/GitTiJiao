package com.example.ce17;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class TwoActivity extends AppCompatActivity {
 private   String string="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=";
   private int a=1;
   private  int qwe;
   private int b=50;
   private Shi shi;
   private RecyclerView rv;
   private Boolean bool;
   Handler handler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           if (msg.what==b){
               Food food = (Food) msg.obj;
               final List<Food.DataBean> data = food.getData();
               rv = findViewById(R.id.rv);
               //设置管理器
               rv.setLayoutManager(new LinearLayoutManager(TwoActivity.this));
               shi = new Shi(TwoActivity.this);
               rv.setAdapter(shi);
               shi.add(data);
               //注册上下文菜单
               registerForContextMenu(rv);

               shi.setOnClickListener(new Shi.OnClickListener() {
                   @Override
                   public void onItemClick(int i) {
                       Intent intent = new Intent(TwoActivity.this,ThreeActivity.class);
                       Food.DataBean dataBean = data.get(i);
                       String pic = dataBean.getPic();
                       String title = dataBean.getTitle();
                       intent.putExtra("pic",pic);
                       intent.putExtra("title",title);
                       startActivity(intent);
                   }
               });
               shi.setOnClickLongListener(new Shi.OnClickLongListener() {
                   @Override
                   public void OnClickLongListener(int i) {
                       qwe=i;
                   }
               });
           }
       }
   };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        conn();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.aaaa,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.one:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
              shi.remove(qwe);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        unregisterForContextMenu(rv);
        super.onDestroy();
    }

    private String con() {
        try {
            URL url = new URL(string+a);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream is = con.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int len=0;
                byte[]bytes= new byte[1024*4];
                while ((len=is.read(bytes))!=-1){
                    bos.write(bytes,0,len);
                }
                String s = bos.toString();;
                return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    private void conn() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String string=con();
                Gson gson = new Gson();
                Food food = gson.fromJson(string, Food.class);
                Message msg = new Message();
                msg.what=b;
                msg.obj=food;
                handler.sendMessage(msg);
            }
        }).start();
    }

}
