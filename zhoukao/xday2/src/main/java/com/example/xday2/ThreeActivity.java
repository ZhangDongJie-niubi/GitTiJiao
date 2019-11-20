package com.example.xday2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ThreeActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
       ImageView iv3 = findViewById(R.id.iv3);
        TextView tv5 = findViewById(R.id.tv5);
        Intent intent = getIntent();
        String pic = intent.getStringExtra("pic");
        String title = intent.getStringExtra("title");
        RequestOptions requestOptions = new RequestOptions();
        RequestOptions requestOptions1 = requestOptions.circleCrop();
        Glide.with(ThreeActivity.this).load(pic).apply(requestOptions1).into(iv3);
        tv5.setText(title);

//        wv = findViewById(R.id.wv);
//        wv.loadUrl("https://www.baidu.com");
//        wv.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                wv.loadUrl("https://www.baidu.com");
//                return super.shouldOverrideUrlLoading(view, request);
//            }
//        });
    }
}
