package com.ayurvihar.somaiya.ayurvihar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.ayurvihar.somaiya.ayurvihar.Activity.Under5.Under_5_Update_Child_Record;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.BackgroundTaskCR;
import com.ayurvihar.somaiya.ayurvihar.BackgroundFunctions.TaskCompleteCR;
import com.ayurvihar.somaiya.ayurvihar.Fragment.Tab1;
import com.ayurvihar.somaiya.ayurvihar.Fragment.Tab2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
public class Under5_Scroll_View extends FragmentActivity implements TaskCompleteCR {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static Context ctx = getApplicationContext();
    public static Under5_Scroll_View view = Under5_Scroll_View.this;

    public ProgressDialog dialog = new ProgressDialog(Under5_Scroll_View.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under5__scroll__view);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        Intent i = getIntent();


        Button update = (Button) findViewById(R.id.update);

        if( i.getStringExtra("type").equals("Scan"))
        {
            update.setEnabled(false);
            update.setAlpha(0.0f);
            update.setText("");
        }


    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter( getSupportFragmentManager());
        adapter.addFrag(new Tab1(), "Nikhil's Tab 1");
        adapter.addFrag(new Tab2(), "Nikhil's Tab 2");
        adapter.addFrag(new Tab2(), "Nikhil's Tab 3");

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
