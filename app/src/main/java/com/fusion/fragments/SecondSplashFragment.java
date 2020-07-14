package com.fusion.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.fusion.R;
import com.fusion.activities.SiginActivity;
import com.fusion.databinding.FragmentSecondSplashBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondSplashFragment extends Fragment {

    private FragmentSecondSplashBinding secondSplashBinding;

    public SecondSplashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        secondSplashBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_splash, container, false);
        View view = secondSplashBinding.getRoot();
        secondSplashBinding.rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SiginActivity.class));
                getActivity().finish();
            }
        });
        return view;
    }
}
