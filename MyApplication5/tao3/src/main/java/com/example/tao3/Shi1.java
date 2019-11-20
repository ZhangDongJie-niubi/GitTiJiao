package com.example.tao3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class Shi1 extends FragmentPagerAdapter {
    private List<Fragment> arr;
    public Shi1(FragmentManager fm,List<Fragment>arr) {
        super(fm);
        this.arr=arr;
    }

    @Override
    public Fragment getItem(int i) {
        return arr.get(i);
    }

    @Override
    public int getCount() {
        return arr.size();
    }
}
