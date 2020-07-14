package com.fusion.activities;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fusion.R;
import com.fusion.adapters.MenuFriendsAdapter;
import com.fusion.adapters.MenuVideoAdapter;
import com.fusion.databinding.ActivityMenuBinding;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private ActivityMenuBinding menuBinding;
    private ArrayList<String> videosList;
    private MenuVideoAdapter menuVideoAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuBinding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        setAdapter();
        setFriendsAdapter();
        menuBinding.ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ProfileActivity.class));
            }
        });
        menuBinding.ivGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, GroupsActivity.class));
            }
        });
        menuBinding.ivCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, CalendarActivity.class));
            }
        });
    }

    private void setFriendsAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        MenuFriendsAdapter menuFriendsAdapter = new MenuFriendsAdapter(this);
        menuBinding.rvMainFriends.setAdapter(menuFriendsAdapter);
        menuBinding.rvMainFriends.setLayoutManager(linearLayoutManager);
        menuBinding.rvMainFriends.addItemDecoration(new ItemDecorator(-30));
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        menuBinding.rvCalendarFriends.setAdapter(menuFriendsAdapter);
        menuBinding.rvCalendarFriends.addItemDecoration(new ItemDecorator(-30));
        menuBinding.rvCalendarFriends.setLayoutManager(linearLayoutManager1);
    }

    private void setAdapter() {
        videosList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        menuVideoAdapter = new MenuVideoAdapter(this, videosList);
        menuBinding.rvVideos.setAdapter(menuVideoAdapter);
        menuBinding.rvVideos.setLayoutManager(linearLayoutManager);

    }

    public static class ItemDecorator extends RecyclerView.ItemDecoration {
        private final int mSpace;

        public ItemDecorator(int space) {
            this.mSpace = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            if (position != 0)
                outRect.left = mSpace;
        }
    }

}
