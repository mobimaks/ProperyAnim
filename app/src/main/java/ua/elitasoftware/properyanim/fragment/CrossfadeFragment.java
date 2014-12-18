package ua.elitasoftware.properyanim.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import ua.elitasoftware.properyanim.R;

/**
 * Created by mobimaks on 17.12.2014.
 */
public class CrossfadeFragment extends Fragment {

    private ActionBar mActionBar;
    private ScrollView mContent;
    private ProgressBar mLoadingSpinner;
    private int mShortAnimationDuration;

    public static CrossfadeFragment newInstance() {
        return new CrossfadeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_crossfade, container, false);

        mContent = (ScrollView) rootView.findViewById(R.id.content);
        mLoadingSpinner = (ProgressBar) rootView.findViewById(R.id.loading_spinner);
        mLoadingSpinner.setVisibility(View.GONE);
        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_mediumAnimTime);

        setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_crossfade, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.crossfade:
                crossfade();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void crossfade() {

        final View view1, view2;
        if (mContent.getVisibility() == View.GONE) {
            view1 = mContent;
            view2 = mLoadingSpinner;
        } else {
            view2 = mContent;
            view1 = mLoadingSpinner;
        }

        view1.setAlpha(0.5f);
        view1.setScaleX(0.3f);
        view1.setScaleY(0.3f);
        view1.setTranslationY(getResources().getDisplayMetrics().heightPixels * 0.8f);
        view1.setVisibility(View.VISIBLE);

        //TODO: debug
//        mShortAnimationDuration = 3000;

        view1.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .translationY(0f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);

        view2.animate()
                .alpha(0f)
                .setDuration(mShortAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        view2.setVisibility(View.GONE);
                    }
                });
    }


}
