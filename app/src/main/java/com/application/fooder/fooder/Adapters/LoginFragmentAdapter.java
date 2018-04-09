package com.application.fooder.fooder.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.application.fooder.fooder.Fragment.LoginFragment;
import com.application.fooder.fooder.Fragment.SignUpFragment;
import com.application.fooder.fooder.R;

public class LoginFragmentAdapter extends FragmentPagerAdapter{
    private Context mContext;
    private final String LOGIN = "login";
    private final String SIGNIN = "signin";

    public LoginFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new LoginFragment();
            case 1: return new SignUpFragment();
            default: return null;
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.login);
            case 1:
                return mContext.getString(R.string.create);
            default:
                return null;
        }
    }

}
