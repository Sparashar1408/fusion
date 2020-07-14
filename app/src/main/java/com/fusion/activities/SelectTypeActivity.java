package com.fusion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fusion.R;
import com.fusion.databinding.ActivitySelectTypeBinding;

public class SelectTypeActivity extends AppCompatActivity {

    private ActivitySelectTypeBinding selectTypeBinding;
    private String from = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectTypeBinding = DataBindingUtil.setContentView(this, R.layout.activity_select_type);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            from = extras.getString("from");
        }
        selectTypeBinding.rlAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (from != null) {
                    Intent intent = new Intent(SelectTypeActivity.this, VideoActivity.class);
                    intent.putExtra("value", 1);
                    startActivity(intent);
                } else {
                    startActivity(new Intent(SelectTypeActivity.this, SuccessActivity.class));
                }
                finish();
            }
        });
        selectTypeBinding.rlVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (from != null) {
                    Intent intent = new Intent(SelectTypeActivity.this, VideoActivity.class);
                    intent.putExtra("value", 2);
                    startActivity(intent);
                } else {
                    startActivity(new Intent(SelectTypeActivity.this, SuccessActivity.class));
                }
                finish();
            }
        });
        selectTypeBinding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
