package com.example.ce003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        WebView wv = findViewById(R.id.wv);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://yun918.cn/study/public/index.php/register");
    }
}
