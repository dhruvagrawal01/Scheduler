package com.example.scheduler;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.io.Serializable;
import java.time.LocalDate;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public final class NewGameActivity extends AppCompatActivity implements Serializable {
    LocalDate localDate;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        CalendarView calendar = findViewById(R.id.calendarView);
        TextView myDate = findViewById(R.id.myDate);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = "    Your selected date: " + (month + 1) + "/" + (dayOfMonth) + "/" + (year);
                myDate.setText((date));
                String stDate = (year) + "-" + (month + 1) + "-" + (dayOfMonth);
                localDate = LocalDate.parse(stDate);
            }
        });
        Button createEvent = findViewById(R.id.createEvent);
        createEvent.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
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
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addEvent() {
        Intent intent = new Intent(this, LaunchActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("localDate", localDate);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void viewEvents() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}
