package com.fusion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fusion.R;
import com.fusion.databinding.ActivityPrivacyBinding;

public class PrivacyActivity extends AppCompatActivity {
    private ActivityPrivacyBinding privacyBinding;
    private String from = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        privacyBinding = DataBindingUtil.setContentView(this, R.layout.activity_privacy);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            from = extras.getString("from");
        }
        privacyBinding.tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrivacyActivity.this, SelectTypeActivity.class);
                if (from != null) {
                    intent.putExtra("from", from);
                }
                startActivity(intent);
                finish();
            }
        });
        privacyBinding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
