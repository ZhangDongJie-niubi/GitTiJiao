package com.example.mvp.base;

import android.os.Bundle;
import android.view.KeyEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    protected Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setView());
        bind = ButterKnife.bind(this);
        BaseApp.mList.add(this);
        init();
    }


    //初始化的方法
    protected abstract void init();

    //加载布局
    protected abstract int setView();


    //监听返回键的方法
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        BaseApp.exit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
            bind = null;
        }
        BaseApp.clearActivtiys();
    }
}


