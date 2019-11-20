package com.example.tao2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int cid = 1;
    private RecyclerView rv;
    private int a;
    private List<Food.DataBean.DatasBean> obj;
    private Food.DataBean.DatasBean datasBean;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            obj = (List<Food.DataBean.DatasBean>) msg.obj;
            rv = findViewById(R.id.rv);
            rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            shi = new Shi(MainActivity.this);
            rv.setAdapter(shi);
            shi.add(obj);
            shi.setOnLongClickListener(new Shi.OnLongClickListener() {
                @Override
                public void onLongClickListener(int i) {
                    a = i;
                }
            });
            shi.setOnClickListener(new Shi.OnClickListener() {
                @Override
                public void onClickListener(int i) {
                    View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.fore, null);
                    final PopupWindow pw = new PopupWindow(inflate, 1000, 500);

                    pw.setOutsideTouchable(true);
                    pw.setBackgroundDrawable(new ColorDrawable());
                    pw.showAtLocation(rv, Gravity.CENTER, 0, 0);
                    final Button but = inflate.findViewById(R.id.que);
                    but.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //通知
                            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                            String id = "id";
                            String name = "name";
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                NotificationChannel nc = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT);
                                nc.enableLights(true);
                                nc.setShowBadge(true);
                                nc.setLightColor(Color.RED);
                                nm.createNotificationChannel(nc);
                            }
                                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                            PendingIntent activity = PendingIntent.getActivity(MainActivity.this, 200, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                                Notification build = new NotificationCompat.Builder(MainActivity.this, id)
                                        .setSmallIcon(R.drawable.icon_wan)
                                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icon_wan))
                                        .setContentText("添加成功")
                                        .setContentTitle("点击进入我的收藏查看")
                                        .setDefaults(Notification.DEFAULT_ALL)
                                        .setContentIntent(activity)
                                        .setBadgeIconType(Notification.BADGE_ICON_LARGE)
                                        .build();
                                nm.notify(100, build);


                        }
                    });
                    Shu shu = new Shu(MainActivity.this, "ku.db", null, 1);
                    Food.DataBean.DatasBean datasBean = obj.get(a);
                    String title = datasBean.getTitle();
                    String chapterName = datasBean.getChapterName();
                    shu.add(title, chapterName);
                }
            });
//            rv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });

        }
    };
    private Shi shi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout dl = findViewById(R.id.dl);
        final LinearLayout ll = findViewById(R.id.ll);
        Toolbar tb = findViewById(R.id.tb);
        tb.setTitle("标题");
        setSupportActionBar(tb);
        ActionBarDrawerToggle abd = new ActionBarDrawerToggle(this, dl, tb, R.string.oppen, R.string.close);
        dl.addDrawerListener(abd);
        abd.syncState();

        initView();

        final SmartRefreshLayout srl = findViewById(R.id.srl);
        srl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                cid++;
                initView();
                srl.finishLoadMore();
            }
        });
        srl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initView();
                srl.finishRefresh();
            }
        });


        dl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
                float v1 = view.getWidth() * v;
                ll.setX(v1);
            }


            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "我的收藏");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://www.wanandroid.com/project/list/1/json?cid=" + cid);
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
                    List<Food.DataBean.DatasBean> datas = food.getData().getDatas();
                    Message msg = new Message();
                    msg.obj = datas;

                    handler.sendMessage(msg);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
