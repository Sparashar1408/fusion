package com.fusion.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.fusion.R;
import com.fusion.databinding.FragmentFirstSplashBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstSplashFragment extends Fragment {

    private FragmentFirstSplashBinding firstSplashBinding;

    public FirstSplashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        firstSplashBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first_splash, container, false);
        View view = firstSplashBinding.getRoot();
        return view;
    }
}
