package com.android3.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainViewPagerAdapter extends FragmentPagerAdapter {


    public MainViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        MainViewPagerFragment fragment =new MainViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pos",position);
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public int getCount()
    {
        return 2;
    }
}
