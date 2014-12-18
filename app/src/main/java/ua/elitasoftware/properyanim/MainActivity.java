package ua.elitasoftware.properyanim;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

import ua.elitasoftware.properyanim.adapter.PagerAdapter;
import ua.elitasoftware.properyanim.fragment.FragmentType;


public class MainActivity extends ActionBarActivity {

    private PagerSlidingTabStrip mTabStrip;
    private ViewPager mViewPager;
    private PagerAdapter mViewPagerAdapter;
    private ArrayList<FragmentType> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();
        initFragmentList();
        initViews();
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(getResources().getDimension(R.dimen.action_bar_elevation));
    }

    private void initFragmentList() {
        mFragments = new ArrayList<>();
        mFragments.add(FragmentType.CROSSFADE);
        mFragments.add(FragmentType.CARD_FLIP);
    }


    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPagerAdapter = new PagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mViewPagerAdapter);

        mTabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mTabStrip.setViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }

}
