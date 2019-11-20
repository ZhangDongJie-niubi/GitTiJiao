package com.example.zhoukao;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import bean.EvenMeg;
import service.HomeService;

public class MainActivity extends AppCompatActivity {
    private String string = "https://gitee.com/Haoxueren/server/raw/master/images/icon_android_300x331.jpg";
    private ProgressBar pb;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取图片空间iv
        ImageView iv = findViewById(R.id.iv);
        //添加图片 并将图片设置成圆形
        RequestOptions requestOptions = new RequestOptions();
        RequestOptions requestOptions1 = requestOptions.circleCrop();
        Glide.with(MainActivity.this).load(string).apply(requestOptions1).into(iv);
        EditText et = findViewById(R.id.et);


        //获取进度条、按钮和文字空间
        pb = findViewById(R.id.pb);
        tv = findViewById(R.id.tv);
        Button but = findViewById(R.id.but);
        //监听按钮空间
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //连接服务
                Intent intent = new Intent(MainActivity.this, HomeService.class);
                //启动服务
                startService(intent);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(EvenMeg evenMeg) {
        //获取当前进度和最大进度的值
        long a = evenMeg.getA();
        long l = evenMeg.getL();
        //给进度条赋值
        pb.setMax((int) l);
        pb.setProgress((int) a);
        //賦值
        tv.setText(a * 100 / l + "%");
        if (a == l) {
            //获取系统服务对象 通知管理器对象
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            String id = "id";
            String name = "name";
            //创建notificationChancel渠道对象
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel nc = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT);
                nc.enableLights(true);
                nc.setShowBadge(true);
                nm.createNotificationChannel(nc);
            }
            //即将跳转的对象
            Intent intent = new Intent(MainActivity.this, TwoActivity.class);
            //封装延时意图的设置
            PendingIntent activity = PendingIntent.getActivity(MainActivity.this, 200, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            //创建notification
            Notification build = new NotificationCompat.Builder(MainActivity.this, id)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setContentTitle("已下载完成")//标题
                    .setContentText("点击跳转")//内容
                    .setContentIntent(activity)//延时意图
                    .build();
            //管理器 发送通知
            nm.notify(100, build);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        //注冊EventBus
        EventBus.getDefault().register(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //停止EventBus
        EventBus.getDefault().unregister(this);
        Intent intent = new Intent(MainActivity.this, HomeService.class);
        //停止服務
        stopService(intent);
    }



}







