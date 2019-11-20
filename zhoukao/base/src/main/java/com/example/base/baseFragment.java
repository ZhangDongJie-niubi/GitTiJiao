package com.example.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class baseFragment extends Fragment {

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getFragmentLayouId(), null);
        bind = ButterKnife.bind(this, inflate);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract int getFragmentLayouId();

    @Override
    public void onDestroy() {
        if (bind != null) {
            bind.unbind();
            bind = null;
        }
        super.onDestroy();
    }
}
