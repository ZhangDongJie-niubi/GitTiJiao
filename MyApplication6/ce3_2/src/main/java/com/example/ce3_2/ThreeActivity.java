package com.example.ce3_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        WebView wv = findViewById(R.id.wv);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("https://www.baidu.com/");

    }
}
