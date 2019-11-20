package com.example.mvpchouqu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.qimojinengbce.R;

public class Fragmentb extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.six, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
//        WebView wv = inflate.findViewById(R.id.wv);
//        wv.setWebViewClient(new WebViewClient());
//        wv.loadUrl("https://www.baidu.com/");

    }


}
