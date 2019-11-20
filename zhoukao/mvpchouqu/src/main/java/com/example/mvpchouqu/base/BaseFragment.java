package com.example.mvpchouqu.base;

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

    protected Unbinder bind;
    protected Presenter mpresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View in = inflater.inflate(setLayout(), null);
        bind = ButterKnife.bind(this, in);
        if (mpresenter == null) {
            mpresenter = CreatePresenter();
            mpresenter.attachView(this);
        }
        return in;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initData();
        super.onActivityCreated(savedInstanceState);
    }

    protected abstract Presenter CreatePresenter();

    protected abstract void initData();

    protected abstract int setLayout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
            bind = null;
        }


    }
}
