package com.fusion.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.fusion.R;
import com.fusion.activities.MenuActivity;
import com.fusion.databinding.FragmentSignUpSecondBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpSecondFragment extends Fragment {

    private FragmentSignUpSecondBinding signUpSecondBinding;

    public SignUpSecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        signUpSecondBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up_second, container, false);
        signUpSecondBinding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MenuActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return signUpSecondBinding.getRoot();
    }
}
