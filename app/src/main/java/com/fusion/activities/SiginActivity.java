package com.fusion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fusion.R;
import com.fusion.databinding.ActivitySigninBinding;

public class SiginActivity extends AppCompatActivity {

    private ActivitySigninBinding signinBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signinBinding = DataBindingUtil.setContentView(SiginActivity.this, R.layout.activity_signin);
        signinBinding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SiginActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signinBinding.tvCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SiginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
