package trackue.atdrive.com.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import trackue.atdrive.com.R;
import trackue.atdrive.com.customs.nestedfragments.FragmentChangeCallback;


class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, FragmentChangeCallback {


    Toolbar mToolbar;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    private Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSupportActionBar(mToolbar);
        mAdapter.addFragment(new DialogFragment(),"test");
        mAdapter.addFragment(new DialogFragment(),"test");
        mAdapter.addFragment(new DialogFragment(),"test");
        mAdapter.addFragment(new DialogFragment(),"test");
        mAdapter.addFragment(new DialogFragment(),"test");
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            switch (i) {
                case 0:
                    tab.setText(getString(R.string.app_name));
                    //tab.setIcon(getDrawable(R.drawable.bg_tab1));
                    break;
                case 1:
                    tab.setText(getString(R.string.app_name));
                    //tab.setIcon(getDrawable(R.drawable.bg_tab1));
                    break;
                case 2:
                    tab.setText(getString(R.string.app_name));
                    //tab.setIcon(getDrawable(R.drawable.bg_tab1));
                    break;
                case 3:
                    tab.setText(getString(R.string.app_name));
                    //tab.setIcon(getDrawable(R.drawable.bg_tab1));
                    break;
                case 4:
                    tab.setText(getString(R.string.app_name));
                   // tab.setIcon(getDrawable(R.drawable.bg_tab1));
                    break;
            }
        }
        mTabLayout.addOnTabSelectedListener(this);

        setCurrentItem(0);


    }


    private void init(){
        //ButterKnife.bind(this);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mTabLayout = (TabLayout)findViewById(R.id.tab_layout);
        mViewPager = (ViewPager)findViewById(R.id.view_pager);
        mAdapter = new Adapter(getSupportFragmentManager());


    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onFragmentChanged() {

    }


    private void setCurrentItem(int position) {
        mViewPager.setCurrentItem(position, false);
        setAppTitle(mAdapter.getPageTitle(position));
    }

    private void setAppTitle(CharSequence title) {
       // ((TextView) mToolbar.findViewById(android.R.id.text1)).setText(title);
    }

    private class Adapter extends FragmentStatePagerAdapter {

        private ArrayList<Fragment> mFragments;
        private ArrayList<String> mTitles;

        public Adapter(FragmentManager fm) {
            super(fm);
            mFragments = new ArrayList<>();
            mTitles = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        private void addFragment(Fragment fragment , String title){

            mFragments.add(fragment);
            mTitles.add(title);
        }
    }

}
