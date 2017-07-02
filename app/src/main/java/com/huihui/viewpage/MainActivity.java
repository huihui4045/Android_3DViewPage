package com.huihui.viewpage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private int[] layouts = {
            R.layout.welcome1,
            R.layout.welcome2,
            R.layout.welcome3,
            R.layout.welcome4,
            R.layout.welcome5,
            R.layout.welcome6
    };
    private HuiViewpageAdapter mViewpageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = (ViewPager) findViewById(R.id.vp);
        vp.setPageTransformer(true,new HuiPageTransformer(), ViewCompat.LAYER_TYPE_HARDWARE);
        mViewpageAdapter = new HuiViewpageAdapter(getSupportFragmentManager());

        vp.setOffscreenPageLimit(2);

        vp.setAdapter(mViewpageAdapter);
    }


    private class HuiViewpageAdapter extends FragmentPagerAdapter {


        public HuiViewpageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = new TranslateFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("layoutId", layouts[position]);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }
    }


}
