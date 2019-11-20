package com.example.ce1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Fragmentb extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.seleven, null);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        WebView wv = inflate.findViewById(R.id.wv);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("https://www.baidu.com/");
    }
}
