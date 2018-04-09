package com.application.fooder.fooder.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.application.fooder.fooder.Fragment.NewsMainActivityFragment;
import com.application.fooder.fooder.R;

public class NewsFeedFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public NewsFeedFragmentAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NewsMainActivityFragment();
            case 1:
                return new NewsMainActivityFragment();
            case 2:
                return new NewsMainActivityFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0: return mContext.getString(R.string.top_feed);
            case 1: return mContext.getString(R.string.fresh);
            case 2: return mContext.getString(R.string.search);
            default: return null;
        }
    }
}
