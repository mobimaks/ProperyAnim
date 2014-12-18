package ua.elitasoftware.properyanim.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.Random;

import ua.elitasoftware.properyanim.fragment.CardFlipFragment;
import ua.elitasoftware.properyanim.fragment.CrossfadeFragment;
import ua.elitasoftware.properyanim.fragment.FragmentType;

/**
 * Created by mobimaks on 17.12.2014.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private ArrayList<FragmentType> mFragments;

    public PagerAdapter(FragmentManager fm, ArrayList<FragmentType> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int i) {
        FragmentType type = mFragments.get(i);

        Fragment fragment;

        switch (type){
            case CROSSFADE:
                fragment = CrossfadeFragment.newInstance();
                break;
            case CARD_FLIP:
                fragment = CardFlipFragment.newInstance();
                break;
            default:
                fragment = CrossfadeFragment.newInstance();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        if (mFragments == null) {
            return 0;
        } else {
            return  mFragments.size();
        }
    }
}
