package com.example.zhoumozuoye4;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class Shi2 extends FragmentPagerAdapter {
    private List<Fragment> arr;
    public Shi2(FragmentManager fm,List<Fragment> arr) {
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
