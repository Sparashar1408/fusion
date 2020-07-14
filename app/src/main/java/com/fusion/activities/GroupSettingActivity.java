package com.fusion.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fusion.R;
import com.fusion.adapters.RvColorsAdapter;
import com.fusion.databinding.ActivityGroupSettingBinding;

public class GroupSettingActivity extends AppCompatActivity {
    private ActivityGroupSettingBinding settingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingBinding = DataBindingUtil.setContentView(this, R.layout.activity_group_setting);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            settingBinding.tvSetting.setText("Fusion Setings");
        }
        settingBinding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setAdapter();
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RvColorsAdapter rvColorsAdapter = new RvColorsAdapter(this);
        settingBinding.rvColors.setAdapter(rvColorsAdapter);
        settingBinding.rvColors.setLayoutManager(linearLayoutManager);
    }
}
