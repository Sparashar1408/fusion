package com.fusion.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.fusion.R;
import com.fusion.databinding.FragmentSignUpFirstBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFirstFragment extends Fragment {

    private FragmentSignUpFirstBinding signUpFirstBinding;

    public SignUpFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        signUpFirstBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up_first, container, false);
        View view = signUpFirstBinding.getRoot();
        signUpFirstBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_signup, new SignUpSecondFragment()).addToBackStack("").commit();
            }
        });
        return view;
    }
}
