package com.example.xiazai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    private Gson gson;
    private String url = "https://cdn.banmi.com/banmiapp/apk/banmi_330.apk";
    private long conut;
    private ProgressBar pb1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = findViewById(R.id.but);
        gson = new GsonBuilder().serializeNulls().create();
        pb1 = findViewById(R.id.pb1);
        tv1 = findViewById(R.id.tv1);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkHttpClient build = new OkHttpClient.Builder().build();
                Request build1 = new Request.Builder()
                        .url(url)
                        .get()
                        .build();
                Call call = build.newCall(build1);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        ResponseBody body = response.body();
                        InputStream inputStream = body.byteStream();
                        long l = body.contentLength();
                        saveFile(inputStream, l, Environment.getExternalStorageDirectory() + "/a.apk");
                    }
                });
            }
        });
    }
    private void saveFile(final InputStream inputStream, final long l, String s) {

        try {
            byte[] bytes = new byte[1024 * 20];
            int len = -1;
            conut = 0;
            pb1.setMax((int) l);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(s));
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
                conut += len;
                Log.e("TAG", "当前进度:" + conut + " / " + l);
                final long fileconut = conut;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() { pb1.setProgress((int) fileconut);


                        tv1.setText(100 * fileconut / l + "%");
                    }
                });
            }
            inputStream.close();
            fileOutputStream.close();


            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                }
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
