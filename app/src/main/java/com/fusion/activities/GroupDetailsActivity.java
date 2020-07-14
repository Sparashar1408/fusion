package com.fusion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fusion.R;
import com.fusion.adapters.AddInviteFriendAdapter;
import com.fusion.adapters.MenuFriendsAdapter;
import com.fusion.databinding.ActivityGroupDetailsBinding;

public class GroupDetailsActivity extends AppCompatActivity {
    private ActivityGroupDetailsBinding detailsBinding;
    private AddInviteFriendAdapter addInviteFriendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_group_details);
        detailsBinding.ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GroupDetailsActivity.this, GroupSettingActivity.class));
            }
        });
        detailsBinding.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsBinding.btnMore.setVisibility(View.GONE);
                addInviteFriendAdapter.showMore();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        MenuFriendsAdapter menuFriendsAdapter = new MenuFriendsAdapter(this);
        detailsBinding.rvMainFriends.setAdapter(menuFriendsAdapter);
        detailsBinding.rvMainFriends.setLayoutManager(linearLayoutManager);
        detailsBinding.rvMainFriends.addItemDecoration(new MenuActivity.ItemDecorator(-30));
        setFriendsAdapter();
    }

    private void setFriendsAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        addInviteFriendAdapter = new AddInviteFriendAdapter(this);
        detailsBinding.rvFriends.setAdapter(addInviteFriendAdapter);
        detailsBinding.rvFriends.setLayoutManager(linearLayoutManager);
    }
}

