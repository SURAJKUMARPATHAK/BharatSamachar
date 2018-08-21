package com.my.bharatsamachar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.my.bharatsamachar.fragment.HomeFragment;
import com.my.bharatsamachar.fragment.LiveTvFragment;
import com.my.bharatsamachar.fragment.PhotoFragment;
import com.my.bharatsamachar.fragment.PlaylistFragment;


public class PagerAdapter extends FragmentPagerAdapter {

    int NumOfTabs;

    public PagerAdapter(FragmentManager fm , int NumOfTabs ) {
        super ( fm );
        this.NumOfTabs = NumOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch ( position ) {
            case 0:
                PlaylistFragment Home = new PlaylistFragment();
                return Home;
            case 1:
                LiveTvFragment LiveTv = new LiveTvFragment();
                return LiveTv;
            case 2:
                PhotoFragment Photo = new PhotoFragment();
                return Photo;



            default:
                return null;
        }
    }
    @Override
    public int getCount () {
        return NumOfTabs;
    }


}