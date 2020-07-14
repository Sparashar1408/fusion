package com.fusion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fusion.R;
import com.fusion.databinding.ActivityAddGroupBinding;

public class AddGroupActivity extends AppCompatActivity {
    private ActivityAddGroupBinding groupsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        groupsBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_group);
        groupsBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddGroupActivity.this, AddFriendsActivity.class));
                finish();
            }
        });
        groupsBinding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
