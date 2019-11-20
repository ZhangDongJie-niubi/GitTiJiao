package com.example.ce_15;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
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

public class TwoActivity extends AppCompatActivity {
    private Food food;
    private ListView lv;
    private int b = 50;
    private Shi shi;
    private int a;
    private List<Food.DataBean> data;
    Handler handler = new Handler() {


        private List<Food.DataBean> data;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == b) {
                data = (List<Food.DataBean>) msg.obj;
                shi = new Shi(TwoActivity.this);
                lv = findViewById(R.id.lv);
                lv.setAdapter(shi);
                shi.add(data);

                lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        a = position;
                        return false;
                    }
                });
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Food.DataBean dataBean = data.get(position);
                        String pic = dataBean.getPic();
                        String title = dataBean.getTitle();
                        Intent intent = new Intent(TwoActivity.this,ThreeActivity.class);
                        intent.putExtra("pic",pic);
                        intent.putExtra("title",title);
                        startActivity(intent);
                    }
                });
                registerForContextMenu(lv);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        conn();
        Toolbar tb = findViewById(R.id.tb);
        tb.setTitle("ToolBar标题");
        setSupportActionBar(tb);
    }


    private void conn() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String string = con();
                Gson gson = new Gson();
                Food food = gson.fromJson(string, Food.class);
                data = food.getData();
                Message msg = new Message();
                msg.what = b;
                msg.obj = data;
                handler.sendMessage(msg);
            }
        }).start();
    }

    private String con() {
        try {
            URL url = new URL("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                InputStream is = con.getInputStream();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                int len = 0;
                byte[] bytes = new byte[1024 * 4];
                while ((len = is.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                String s = bos.toString();
                Log.i("tag", s);
                bos.close();
                is.close();
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.aaa, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one:
                List<Food.DataBean> list = shi.getList();
                list.remove(a);
                shi.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }



    @Override
    protected void onDestroy() {
        unregisterForContextMenu(lv);
        super.onDestroy();
    }
}
