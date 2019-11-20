package com.example.mvp.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter implements IMvpPresenter {
    protected WeakReference<Object> mWeakReference;
    //存放网络开关的容器
    protected CompositeDisposable mComposide;


    //用来和V层关联的  弱引用修饰V层引用
    @Override
    public void attachView(Object v) {
        if (mWeakReference == null)
            mWeakReference = new WeakReference<Object>(v);
    }


    //添加网络开关 和M层相关
    public void addDisposeable(Disposable disposable) {
        if (mComposide == null)
            mComposide = new CompositeDisposable();
        mComposide.add(disposable);
    }


    //取消和V层关联，及时释放掉V层引用
    @Override
    public void detachView() {
        if (mWeakReference != null) {
            mWeakReference.clear();
            mWeakReference = null;
        }
        if (mComposide != null && !mComposide.isDisposed()) {
            mComposide.dispose();
            mComposide.clear();
            mComposide = null;
        }
    }
}
