package com.example.zhoumozuoye1;

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
        WebView web = findViewById(R.id.web);
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(link);
    }
}
