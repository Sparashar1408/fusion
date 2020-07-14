package com.fusion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fusion.R;
import com.fusion.adapters.ProfileViewPagerAdapter;
import com.fusion.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {
    private ActivityProfileBinding profileBinding;
    // Titles of the individual pages (displayed in tabs)
    private final String[] PAGE_TITLES = new String[]{
            "",
            "",
            ""
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile);
//        setSupportActionBar(profileBinding.toolbar);
        // Connect the ViewPager to our custom PagerAdapter. The PagerAdapter supplies the pages
        // (fragments) to the ViewPager, which the ViewPager needs to display.
        profileBinding.viewPager.setAdapter(new ProfileViewPagerAdapter(getSupportFragmentManager(), PAGE_TITLES));
        // Connect the tabs with the ViewPager (the setupWithViewPager method does this for us in
        // both directions, i.e. when a new tab is selected, the ViewPager switches to this page,
        // and when the ViewPager switches to a new page, the corresponding tab is selected)
        profileBinding.tabLayout.setupWithViewPager(profileBinding.viewPager);
        profileBinding.ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, SettingActivity.class));
            }
        });
        profileBinding.llEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class));
            }
        });
    }
}
