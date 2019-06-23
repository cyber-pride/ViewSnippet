package com.bluapp.viewsnippet;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private int fragmentSize = 3;
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0 : return new FirstFragment();
            case 1 : return new FirstFragment();
            case 2 : return new FirstFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragmentSize;
    }
}
