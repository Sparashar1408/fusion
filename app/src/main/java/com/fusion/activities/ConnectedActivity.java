package com.fusion.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fusion.R;
import com.fusion.adapters.ConnectedAccountAdapter;
import com.fusion.databinding.ActivityConnectedBinding;

public class ConnectedActivity extends AppCompatActivity {

    private ActivityConnectedBinding connectedBinding;
    private ConnectedAccountAdapter accountAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectedBinding = DataBindingUtil.setContentView(this, R.layout.activity_connected);
        setAdapter();
        connectedBinding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        accountAdapter = new ConnectedAccountAdapter(this);
        connectedBinding.rvAccounts.setAdapter(accountAdapter);
        connectedBinding.rvAccounts.setLayoutManager(layoutManager);
    }
}
