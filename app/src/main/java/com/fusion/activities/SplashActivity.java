package com.fusion.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.fusion.R;
import com.fusion.adapters.ViewPagerAdapter;
import com.fusion.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding splashBinding;
    private int dotscount;
    private ImageView[] ivDots;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashBinding = DataBindingUtil.setContentView(SplashActivity.this, R.layout.activity_splash);
        setViewPager();
        dotscount = viewPagerAdapter.getCount();
        ivDots = new ImageView[dotscount];
        for (int i = 0; i < dotscount; i++) {
            ivDots[i] = new ImageView(SplashActivity.this);
            ivDots[i].setImageDrawable(ContextCompat.getDrawable(SplashActivity.this, R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            splashBinding.dots.addView(ivDots[i], params);
        }
        ivDots[0].setImageDrawable(ContextCompat.getDrawable(SplashActivity.this, R.drawable.active_dot));
        splashBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++) {
                    ivDots[i].setImageDrawable(ContextCompat.getDrawable(SplashActivity.this, R.drawable.nonactive_dot));
                }
                ivDots[position].setImageDrawable(ContextCompat.getDrawable(SplashActivity.this, R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setViewPager() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        splashBinding.viewPager.setAdapter(viewPagerAdapter);
    }
}
