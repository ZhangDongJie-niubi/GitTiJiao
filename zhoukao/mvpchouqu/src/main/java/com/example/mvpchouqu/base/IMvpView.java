package com.example.mvpchouqu.base;

public interface IMvpView<T> {
    void showLoading();

    void dimisLoading();

    void onScuessData(T t);

    void onFaileData(String msg);

}
