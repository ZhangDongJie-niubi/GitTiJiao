package com.example.zhoumozuoye1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class Shi2 extends FragmentPagerAdapter {
   private List<Fragment> fra;

    public Shi2(FragmentManager fm, List<Fragment> fra) {
        super(fm);
        this.fra = fra;
    }

    @Override
    public Fragment getItem(int i) {
        return fra.get(i);
    }

    @Override
    public int getCount() {
        return fra.size();
    }
}
