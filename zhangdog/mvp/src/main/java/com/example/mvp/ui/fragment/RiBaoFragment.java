package com.example.mvp.ui.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mvp.R;
import com.example.mvp.adapter.HomeViewPagerAdapter;
import com.example.mvp.base.BaseFragment;
import com.example.mvp.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class RiBaoFragment extends BaseFragment {
    @BindView(R.id.home_tablayout)
    TabLayout homeTablayout;
    @BindView(R.id.home_viewpager)
    ViewPager homeViewpager;
    private int[] mTableTitle = {R.string.ribao, R.string.zhuti, R.string.zhuanlan, R.string.remen};



    @Override
    protected void init() {
        List<Fragment> mList = new ArrayList<Fragment>();
        for (int i = 0; i < mTableTitle.length; i++) {
            RiBaoSubFragment riBaoSubFragment = new RiBaoSubFragment(i);
            mList.add(riBaoSubFragment);
        }
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter
                (getChildFragmentManager(), mList, mTableTitle);
        homeViewpager.setAdapter(adapter);
        homeTablayout.setupWithViewPager(homeViewpager);
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
        return R.layout.layout_fragment_ribao;
    }

    @Override
    protected void release() {

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
}
