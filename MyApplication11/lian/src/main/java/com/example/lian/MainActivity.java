package com.example.lian;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private File file;
    private String url = "http://yun918.cn/study/public/file_upload.php";
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv);
        Button but1 = findViewById(R.id.but1);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initView(file);
            }
        });
    }

    private void initView(File file) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            Uri uri = data.getData();
            file = getfiles(uri, this);
            if (file != null) {
                ok(file);
            }
        } else if (requestCode == 2) {
            ok(file);
        }
    }

    private File getfiles(Uri uri, MainActivity mainActivity) {
        if (uri == null) {
            return null;
        }
        switch (uri.getScheme()) {
            case "content":
                return getDatas(uri, mainActivity);
            case "file":
                return new File(uri.getPath());
            default:
                return null;
        }

    }

    private File getDatas(Uri uri, MainActivity mainActivity) {
        if (uri == null) {
            return null;
        }
        File file = null;
        String Path = null;
        String[] str = {MediaStore.MediaColumns.DATA};
        Cursor query = mainActivity.getContentResolver().query(uri, str, null, null, null);
        if (query != null) {
            query.moveToFirst();
            Path = query.getString(query.getColumnIndex(str[0]));
            if (!TextUtils.isEmpty(Path)) {
                file = new File(Path);
            }
        }
        return file;

    }


    private void ok(File file) {
        OkHttpClient build = new OkHttpClient.Builder().build();
        MediaType parse = MediaType.parse("image/jpg");
        RequestBody requestBody = MultipartBody.create(parse, file);
        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("key", "1803")
                .addFormDataPart("file", file.getName(), requestBody)
                .build();
        Request build1 = new Request.Builder()
                .post(multipartBody)
                .url(url)
                .build();

        Call call = build.newCall(build1);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("LAG", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new GsonBuilder().serializeNulls().create();
                final Food food = gson.fromJson(string, Food.class);
                final String res = food.getRes();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(MainActivity.this).load(food.getData().getUrl()).into(iv);
                    }
                });
            }
        });

    }
}
