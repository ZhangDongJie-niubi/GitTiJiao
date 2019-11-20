package service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;

import androidx.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import bean.He;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Homeservice extends Service {
    String url = "http://cdn.banmi.com/banmiapp/apk/banmi_330.apk";
    private long a;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        OkHttpClient build1 = new OkHttpClient.Builder().build();
        Request build = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = build1.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                InputStream inputStream = body.byteStream();
                long l = body.contentLength();
                saveFile(inputStream, l, Environment.getExternalStorageDirectory() + "/a.apk");
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
                EventBus.getDefault().postSticky(new He(a, l));
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
