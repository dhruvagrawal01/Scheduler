package com.example.scheduler;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import java.time.LocalDate;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;



public final class GameActivity extends AppCompatActivity implements EventsName {
    LocalDate eventDate;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView eventOnDate = findViewById(R.id.eventOnDate);
        CalendarView calendar = findViewById(R.id.calendarView);
        TextView myDate = findViewById(R.id.myDate);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = "    Your selected date: " + (month + 1) + "/" + (dayOfMonth) + "/" + (year);
                myDate.setText((date));
                String stDate = (year) + "-" + (month + 1) + "-" + (dayOfMonth);
                eventDate = LocalDate.parse(stDate);
                String event = "    Event on this date: " + map.get(eventDate);
                eventOnDate.setText((event));
            }
        });
        Button addNewEvent = findViewById(R.id.addNewEvent);
        addNewEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEvent();
            }
        });
    }

    public void addNewEvent() {
        Intent intent = new Intent(this, NewGameActivity.class);
        startActivity(intent);
        finish();
    }
}
