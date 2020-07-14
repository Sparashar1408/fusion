package com.fusion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fusion.R;
import com.fusion.adapters.AddInviteFriendAdapter;
import com.fusion.databinding.ActivityAddFriendsBinding;

public class AddFriendsActivity extends AppCompatActivity {
    private ActivityAddFriendsBinding addFriendsBinding;
    private AddInviteFriendAdapter addInviteFriendAdapter;
    private String from = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFriendsBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_friends);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            from = extras.getString("from");
        }
        setInviteFriendsAdapter();
        setFriendsAdapter();
        addFriendsBinding.tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddFriendsActivity.this, PrivacyActivity.class);
                if (from != null) {
                    intent.putExtra("from", from);
                }
                startActivity(intent);
                finish();
            }
        });
        addFriendsBinding.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFriendsBinding.btnMore.setVisibility(View.GONE);
                addInviteFriendAdapter.showMore();
            }
        });
    }

    private void setInviteFriendsAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddFriendsActivity.this, LinearLayoutManager.VERTICAL, false);
        addInviteFriendAdapter = new AddInviteFriendAdapter(AddFriendsActivity.this);
        addFriendsBinding.rvInviteFriends.setAdapter(addInviteFriendAdapter);
        addFriendsBinding.rvInviteFriends.setLayoutManager(linearLayoutManager);
    }


    private void setFriendsAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddFriendsActivity.this, LinearLayoutManager.VERTICAL, false);
        addInviteFriendAdapter = new AddInviteFriendAdapter(AddFriendsActivity.this);
        addFriendsBinding.rvFriends.setAdapter(addInviteFriendAdapter);
        addFriendsBinding.rvFriends.setLayoutManager(linearLayoutManager);
    }
}
