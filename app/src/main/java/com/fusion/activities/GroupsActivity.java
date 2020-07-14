package com.fusion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;
import com.fusion.adapters.GroupFriendsAdapter;
import com.fusion.adapters.MenuFriendsAdapter;
import com.fusion.databinding.ActivityGroupsBinding;

public class GroupsActivity extends AppCompatActivity {
    private ActivityGroupsBinding groupsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        groupsBinding = DataBindingUtil.setContentView(this, R.layout.activity_groups);
        groupsBinding.btnFusion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GroupsActivity.this, FusionActivity.class));
            }
        });
        groupsBinding.ivAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GroupsActivity.this, AddGroupActivity.class));
            }
        });
        groupsBinding.ivCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GroupsActivity.this, NewCalendarActivity.class));
            }
        });
        groupsBinding.rlGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GroupsActivity.this, GroupDetailsActivity.class));
            }
        });
        setGroupsAdapter();
        setFriendsAdapter();
    }

    private void setGroupsAdapter() {
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        GroupFriendsAdapter groupFriendsAdapter = new GroupFriendsAdapter(this);
        groupsBinding.rvGroups.setAdapter(groupFriendsAdapter);
        groupsBinding.rvGroups.setLayoutManager(linearLayoutManager);
    }

    private void setFriendsAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        MenuFriendsAdapter menuFriendsAdapter = new MenuFriendsAdapter(this);
        groupsBinding.rvMainFriends.setAdapter(menuFriendsAdapter);
        groupsBinding.rvMainFriends.setLayoutManager(linearLayoutManager);
        groupsBinding.rvMainFriends.addItemDecoration(new MenuActivity.ItemDecorator(-30));
    }
}
