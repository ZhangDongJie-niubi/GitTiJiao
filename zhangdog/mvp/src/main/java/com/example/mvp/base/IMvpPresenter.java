package com.example.mvp.base;

//1.桥梁 连接了M层和V层  2.处理业务逻辑
//3.处理内存泄露(断开网络请求，及时释放掉M层引用, 及时释放调V层的引用 就避免内存泄露)
public interface IMvpPresenter<T> {
    //从M层请求数据，并处理业务逻辑
    void requestData();

    //先和V层关联
    void attachView(T t);

    //释放掉V层引用
    void detachView();


}
