package com.example.mvpchouqu.base;


import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


import com.example.mvpchouqu.R;
import com.example.mvpchouqu.adpter.HomeViewPagerAdpter;
import com.example.mvpchouqu.base.BaseActivity;
import com.example.mvpchouqu.fragment.HomeFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;
    @BindView(R.id.home_tablayout)
    TabLayout homeTablayout;
    @BindView(R.id.home_viewpager)
    ViewPager homeViewpager;
    @BindView(R.id.design_navigation_view)
    NavigationView designNavigationView;
    private int[] mTableTitle = {R.string.ribao, R.string.zhuti, R.string.zhuanlan, R.string.remen};

    @Override
    protected int setView() {
        return R.layout.activity_main;
    }
    @Override

    protected void init() {
        List<Fragment> mList = new ArrayList<Fragment>();
        for (int i = 0; i < mTableTitle.length; i++) {
            HomeFragment homeFragment = new HomeFragment(i);
            mList.add(homeFragment);
        }
        HomeViewPagerAdpter adapter = new HomeViewPagerAdpter
                (getSupportFragmentManager(), mList, mTableTitle);
        homeViewpager.setAdapter(adapter);
        homeTablayout.setupWithViewPager(homeViewpager);
    }


}

