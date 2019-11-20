package com.example.mvpchouqu.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter implements IMvpPresenter {
    protected WeakReference<Object> mWeakReference;
    protected CompositeDisposable mComposide;


    public void addDisposavle(Disposable disposable) {
        if (mComposide == null) {
            mComposide = new CompositeDisposable();
            mComposide.add(disposable);
        }
    }

    @Override
    public void attachView(Object o) {
        if (mWeakReference == null) {
            mWeakReference = new WeakReference<Object>(o);
        }
    }

    @Override
    public void detachView() {
        if (mComposide != null) {
            mComposide.clear();
            mComposide = null;
        }
        if (mComposide != null) {
            mComposide.dispose();
            mComposide.clear();
            mComposide = null;
        }
    }
}
