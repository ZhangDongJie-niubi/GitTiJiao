package com.example.zongheti2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        WebView wv = findViewById(R.id.wv);
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(link);
    }
}
