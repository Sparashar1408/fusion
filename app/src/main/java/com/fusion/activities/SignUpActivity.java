package com.fusion.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import com.fusion.R;
import com.fusion.databinding.ActivitySignUpBinding;
import com.fusion.fragments.SignUpFirstFragment;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding signUpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = DataBindingUtil.setContentView(SignUpActivity.this, R.layout.activity_sign_up);
        loadFragment();
    }

    private void loadFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_signup, new SignUpFirstFragment()).addToBackStack(null).commit();
    }
}
