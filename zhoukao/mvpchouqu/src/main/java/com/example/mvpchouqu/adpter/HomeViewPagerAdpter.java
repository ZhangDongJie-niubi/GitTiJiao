package com.example.mvpchouqu.adpter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mvpchouqu.base.BaseApp;

import java.util.List;

public class HomeViewPagerAdpter extends FragmentPagerAdapter {
    private List<Fragment> mList;
    private int[] mStrIds;


    public HomeViewPagerAdpter(@NonNull FragmentManager fm, List<Fragment> mList, int[] tableTitle) {
        super(fm);
        this.mList = mList;
        mStrIds = tableTitle;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return BaseApp.getContext().getString(mStrIds[position]);

    }
}
