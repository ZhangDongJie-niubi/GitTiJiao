package com.example.ce019.server;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.ce019.bean.EvenMeg;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HomeServer extends Service {
    String url = "https://alissl.ucdl.pp.uc.cn/fs08/2017/05/02/7/106_64d3e3f76babc7bce131650c1c21350d.apk";
    private long a;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        OkHttpClient build = new OkHttpClient.Builder().build();
        Request build1 = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = build.newCall(build1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: "+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                final InputStream inputStream = body.byteStream();
                final long l = body.contentLength();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        saveFile(inputStream, l, Environment.getExternalStorageDirectory() + "/0.apk");
                }
                }).start();
            }

        });
        return super.onStartCommand(intent, flags, startId);
    }

    private void saveFile(InputStream inputStream, long l, String s) {

        try {
            int len = -1;
            byte[] bytes = new byte[1024 * 20];
            a = 0;
            FileOutputStream fileOutputStream = new FileOutputStream(new File(s));
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
                a += len;
                EventBus.getDefault().post(new EvenMeg(a, l));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}