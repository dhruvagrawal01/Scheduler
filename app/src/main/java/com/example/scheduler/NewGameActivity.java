package com.example.scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public final class NewGameActivity extends AppCompatActivity {
    int setYear;
    int setMonth;
    int setDayOfMonth;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        CalendarView calendar = findViewById(R.id.calendarView);
        TextView myDate = findViewById(R.id.myDate);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = "    Your selected date: " + (month + 1) + "/" + (dayOfMonth) + "/" + (year);
                myDate.setText((date));
                setDayOfMonth = dayOfMonth;
                setMonth = month;
                setYear = year;
            }
        });
        Button createEvent = findViewById(R.id.createEvent);
        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();
            }
        });
        Button viewEvents = findViewById(R.id.viewEvents);
        viewEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewEvents();
            }
        });

    }
    public void addEvent() {
        Intent intent = new Intent(this, LaunchActivity.class);
        intent.putExtra("month", setMonth);
        intent.putExtra("year", setYear);
        intent.putExtra("dayOfMonth", setDayOfMonth);
        startActivity(intent);
        finish();
    }
    public void viewEvents() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}
