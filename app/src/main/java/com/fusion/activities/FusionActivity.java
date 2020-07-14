package com.fusion.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.fusion.R;
import com.fusion.adapters.ScheduleAdapter;
import com.fusion.databinding.ActivityFusionBinding;
import com.fusion.interfaces.ClickInterface;

public class FusionActivity extends AppCompatActivity implements ClickInterface {
    private ActivityFusionBinding fusionBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fusionBinding = DataBindingUtil.setContentView(this, R.layout.activity_fusion);
        setAdapter();
    }

    private void setAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter(this);
        fusionBinding.rvFusions.setAdapter(scheduleAdapter);
        scheduleAdapter.setListerner(this);
        fusionBinding.rvFusions.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void click() {
        Intent intent = new Intent(this, AddFriendsActivity.class);
        intent.putExtra("from", "fusion");
        startActivity(intent);
    }
}
