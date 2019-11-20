package com.example.day13;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //获取系统服务对象 通知管理器对象
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                String id = "id";
                String name = "name";
                //创建notificationChancel渠道对象
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel nc = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT);
                    nc.enableLights(true);
                    nc.setShowBadge(true);
                    nc.setLightColor(Color.RED);
                    nm.createNotificationChannel(nc);
                }
                //即将跳转的对象
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                //封装延时意图的设置
                PendingIntent activity = PendingIntent.getActivity(MainActivity.this, 200, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                //真正去创建notification
                Notification build = new NotificationCompat.Builder(MainActivity.this, id)
                        .setSmallIcon(R.mipmap.ic_launcher)//图片
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setContentTitle("title")//标题
                        .setContentText("text")//内容
                        .setContentIntent(activity)//延时意图
                        .setBadgeIconType(Notification.BADGE_ICON_LARGE)
                        .build();
                //管理器 发送通知
                nm.notify(100, build);
            }
        });
    }
}
