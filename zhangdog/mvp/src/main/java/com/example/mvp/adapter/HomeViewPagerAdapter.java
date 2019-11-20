package com.example.mvp.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mvp.base.BaseApp;

import java.util.List;

public class HomeViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mList;
    private int[] mStrIds;

    public HomeViewPagerAdapter(@NonNull FragmentManager fm,
                                List<Fragment> list, int[] tableTitle) {
        super(fm);
        this.mList = list;
        mStrIds = tableTitle;

    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return BaseApp.getContext().getString(mStrIds[position]);
    }
}
