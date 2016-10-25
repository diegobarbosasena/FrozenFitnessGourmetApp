package br.com.frozenfitnessgourmet.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by 15160046 on 25/10/2016.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    private static final int tabs = 3;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new SimpleFragment(position);
    }

    @Override
    public int getCount() {
        return tabs;
    }
}
