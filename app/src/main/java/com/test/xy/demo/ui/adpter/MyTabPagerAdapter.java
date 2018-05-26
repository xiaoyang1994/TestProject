package com.test.xy.demo.ui.adpter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyTabPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private  String[] mStringArray;

    public MyTabPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] stringArray) {
        super(fm);
        mFragments = fragments;
        mStringArray = stringArray;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mStringArray[position];
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
