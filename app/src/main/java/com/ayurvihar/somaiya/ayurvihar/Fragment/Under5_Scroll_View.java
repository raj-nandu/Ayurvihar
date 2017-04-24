package com.ayurvihar.somaiya.ayurvihar.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.EditText;

import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.TaskCompleteCR;
import com.ayurvihar.somaiya.ayurvihar.R;

import java.util.ArrayList;
import java.util.List;
public class Under5_Scroll_View extends FragmentActivity implements TaskCompleteCR {

    private TabLayout tabLayout;
    private ViewPager viewPager;
   EditText Addn1 , Addn2 , Addn3 , Addn4 , Addn5 , Addn6 , Addn7 , Addn8 , Addn9;
    public static Context ctx;
    public static Under5_Scroll_View SV;

    public static ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under5__scroll__view);
        Intent i = getIntent();
        ctx = getApplicationContext();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        SV = Under5_Scroll_View.this;
        dialog = new ProgressDialog(Under5_Scroll_View.this);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter( getSupportFragmentManager());
        adapter.addFrag(new Tab1(), "          Child Data          ");
        adapter.addFrag(new Tab2(), "          Immunization          ");
        adapter.addFrag(new Tab3(), "          Health Checkup          ");
        adapter.addFrag(new Tab4(), "          Health Checkup Records          ");

        this.viewPager.setAdapter(adapter);

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

    public void TaskCreate()
    {

    }
    public void TaskUpdate()

    {

    }
    public void TaskRecords()
    {

    }
}
