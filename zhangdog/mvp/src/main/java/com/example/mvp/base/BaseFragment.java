package com.example.mvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<Presenter extends BasePresenter> extends Fragment implements IMvpView {
    private Unbinder mBind;
    private Presenter mPresenter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        if (setLayout() != 0) {
            view = inflater.inflate(setLayout(), container, false);
            mBind = ButterKnife.bind(this, view);
        }
        //P层关联V层引用
        if (mPresenter == null)
            mPresenter = createPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init();
        initData();
        super.onViewCreated(view, savedInstanceState);
    }


    protected abstract void init();

    //初始化数据
    protected abstract void initData();

    protected abstract Presenter createPresenter();

    protected abstract int setLayout();

    @Override
    public void onDestroy() {
        if (mBind != null) {
            mBind.unbind();
            mBind = null;
        }
        //释放V层引用并断开网络开关
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
        release();
    }

    protected abstract void release();
}
