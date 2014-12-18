package ua.elitasoftware.properyanim.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.elitasoftware.properyanim.R;

/**
 * Created by mobimaks on 18.12.2014.
 */

public class CardFrontFragment extends Fragment {

    public static CardFrontFragment newInstance(){
        return new CardFrontFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_card_flip_front, container, false);
    }

}