package com.example.mvp.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.example.mvp.HomeActivity;
import com.example.mvp.R;
import com.example.mvp.base.BaseFragment;
import com.example.mvp.base.BasePresenter;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class JingXuanFragment extends BaseFragment implements MaterialSearchView.OnQueryTextListener {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    private MaterialSearchView searchView;

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu, menu);
        FragmentActivity activity = getActivity();
        if (activity instanceof HomeActivity) {
            searchView = ((HomeActivity) activity).getSearchView();
            MenuItem item = menu.findItem(R.id.search_item);
            searchView.setMenuItem(item);
            searchView.setOnQueryTextListener(this);

        }

    }

    @Override
    protected void init() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @Override
    protected int setLayout() {
        return 0;
    }

    @Override
    protected void release() {
        if (searchView != null && searchView.isSearchOpen())
            searchView.closeSearch();
        searchView = null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dimisLoading() {

    }

    @Override
    public void onScuessData(Object o) {

    }

    @Override
    public void onFaileData(String msg) {

    }


    // 提交查询文本  点击搜索的时候执行这个方法
    @Override
    public boolean onQueryTextSubmit(String query) {
        if (searchView != null && searchView.isSearchOpen()) {
            Log.e("TAGF", query + "+=====onQueryTextSubmit===");
            searchView.closeSearch();
            //TODO  query  上傳後臺 查詢數據
        }
        return true;
    }

    //查詢文本改變了  搜索框里面输入内容的时候执行这个方法
    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("TAGF", newText + "+=====onQueryTextChange===");
        return true;
    }
}
