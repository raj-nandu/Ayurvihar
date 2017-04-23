package com.ayurvihar.somaiya.ayurvihar;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.ayurvihar.somaiya.ayurvihar.Fragment.Tab1;
import com.ayurvihar.somaiya.ayurvihar.Fragment.Tab2;
import com.ayurvihar.somaiya.ayurvihar.Fragment.Tab3;

import java.util.ArrayList;
import java.util.List;

public class Under5_Scroll_View extends Activity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under5__scroll__view);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Tab1(), "Child Data");
        adapter.addFrag(new Tab2(), "Immunization");
        adapter.addFrag(new Tab3(), "Health Checkup");

       viewPager.setAdapter(adapter);
       /* if( !Saved.textTab1.equals(""))
        {
            EditText e = (EditText) findViewById(R.id.Text1);
            e.setText(Saved.textTab1);
        }
        if( !Saved.textTab2.equals(""))
        {
            EditText e = (EditText) findViewById(R.id.Text2);
            e.setText(Saved.textTab2);
        }
        if( !Saved.textTab3.equals(""))
        {
            EditText e = (EditText) findViewById(R.id.Text3);
            e.setText(Saved.textTab3);
        }*/
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
