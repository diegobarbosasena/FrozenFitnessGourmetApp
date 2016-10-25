package br.com.frozenfitnessgourmet.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by 15160046 on 25/10/2016.
 */

public class TabActivity extends ActionBarActivity {

    private ViewPager viewPager;
    private ActionBar actionBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tab);

        viewPager = (ViewPager) findViewById(R.id.pager);

        FragmentManager fm = getSupportFragmentManager();
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(fm);
        viewPager.setAdapter(pagerAdapter);



    }
}
