package com.fusion.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fusion.fragments.FirstSplashFragment;
import com.fusion.fragments.SecondSplashFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return new FirstSplashFragment();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return new SecondSplashFragment();
            default:
                return new FirstSplashFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}