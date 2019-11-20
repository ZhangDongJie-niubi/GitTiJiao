package com.example.mvpchouqu.adpter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class Fragmentadpter extends FragmentPagerAdapter {
    private List<Fragment> arr;

    public Fragmentadpter(@NonNull FragmentManager fm, List<Fragment> arr) {
        super(fm);
        this.arr = arr;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arr.get(position);
    }

    @Override
    public int getCount() {
        return arr.size();
    }
}
