package com.fusion.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fusion.R;
import com.fusion.adapters.CalendarAdapter;
import com.fusion.databinding.ActivityCalendarBinding;

public class CalendarActivity extends AppCompatActivity {
    private ActivityCalendarBinding calendarBinding;
    private CalendarAdapter calendarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calendarBinding = DataBindingUtil.setContentView(this, R.layout.activity_calendar);
        calendarBinding.btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CalendarActivity.this, NewCalendarActivity.class));
            }
        });
        setAdapter();
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        calendarAdapter = new CalendarAdapter(this);
        calendarBinding.rvCalendar.setAdapter(calendarAdapter);
        calendarBinding.rvCalendar.setLayoutManager(linearLayoutManager);
    }
}
