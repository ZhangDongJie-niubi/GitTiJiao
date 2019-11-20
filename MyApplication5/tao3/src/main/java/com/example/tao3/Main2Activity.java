package com.example.tao3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        WebView wv = findViewById(R.id.wv);

        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(link);
    }
}
