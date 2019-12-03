package com.example.scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public final class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        String eventName = intent.getStringExtra("eventName");
        int setMonth = intent.getIntExtra("month", 12);
        int setYear = intent.getIntExtra("year", 2019);
        int setDayOfMonth = intent.getIntExtra("dayOfMonth", 1);


        TextView eventOnDate = findViewById(R.id.eventOnDate);

        CalendarView calendar = findViewById(R.id.calendarView);
        TextView myDate = findViewById(R.id.myDate);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = "    Your selected date: " + (month + 1) + "/" + (dayOfMonth) + "/" + (year);
                myDate.setText((date));
                String event = "    Event on this date: " + (eventName);
                if (setMonth == month && setYear == year && setDayOfMonth == dayOfMonth) {
                    eventOnDate.setText((event));
                }
            }
        });
    }
}
