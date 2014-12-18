package ua.elitasoftware.properyanim.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import ua.elitasoftware.properyanim.R;

/**
 * Created by mobimaks on 18.12.2014.
 */

public class CardFlipFragment extends Fragment {

    private Fragment mCurrentFragment;

    public static CardFlipFragment newInstance() {
        return new CardFlipFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //noinspection UnnecessaryLocalVariable
        View rootView = inflater.inflate(R.layout.fragment_card_flip, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCurrentFragment = CardFrontFragment.newInstance();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.card_flip_container, mCurrentFragment)
                .commit();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_card_flip, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.flip_card) {
            flipCards();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void flipCards() {
        if (mCurrentFragment instanceof CardFrontFragment) {
            mCurrentFragment = CardBackFragment.newInstance();
        } else {
            mCurrentFragment = CardFrontFragment.newInstance();
        }
        setFragment();
    }

    private void setFragment() {
        getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.card_flip_right_in, R.anim.card_flip_right_out,
                        R.anim.card_flip_left_in, R.anim.card_flip_left_out)
                .replace(R.id.card_flip_container, mCurrentFragment)
                .addToBackStack(null)
                .commit();
    }

}
