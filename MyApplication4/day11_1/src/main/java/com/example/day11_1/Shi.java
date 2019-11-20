package com.example.day11_1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class Shi extends FragmentPagerAdapter {
    List<Fragmenta> arr;
    public Shi(FragmentManager fm,List<Fragmenta> arr) {
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
