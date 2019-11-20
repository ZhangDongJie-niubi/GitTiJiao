package com.example.mvp.base;

public interface IMvpView<T> {
    //显示进度条
    void showLoading();

    //隐藏进度条
    void dimisLoading();

    //请求成功然后更新UI
    void onScuessData(T t);

    //请求失败然后更新UI
    void onFaileData(String msg);


}
