package com.fusion.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fusion.fragments.FriendsFragment;

public class ProfileViewPagerAdapter extends FragmentPagerAdapter {
    private String[] PAGE_TITLES;

    public ProfileViewPagerAdapter(@NonNull FragmentManager fm, String[] PAGE_TITLES) {
        super(fm);
        this.PAGE_TITLES = PAGE_TITLES;
    }

    @Override
    public Fragment getItem(int position) {
        return new FriendsFragment(position);
    }

    @Override
    public int getCount() {
        return PAGE_TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PAGE_TITLES[position];
    }
}
