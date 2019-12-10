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
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public final class NewGameActivity extends AppCompatActivity implements Serializable {
    LocalDate localDate;
    Map<LocalDate, String> map = EventsName.getInstance().map;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        CalendarView calendar = findViewById(R.id.calendarView);
        TextView myDate = findViewById(R.id.myDate);
        TextView eventOnDate = findViewById(R.id.eventOnDate);


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = "    Your selected date: " + (month + 1) + "/" + (dayOfMonth) + "/" + (year);
                myDate.setText((date));
                String stDate = (year) + "-" + (month + 1) + "-" + (dayOfMonth);
                if (month + 1 < 10 && dayOfMonth < 10) {
                    stDate = (year) + "-" + "0" + (month + 1) + "-" + "0" + (dayOfMonth);
                } else if (month + 1 < 10) {
                    stDate = (year) + "-" + "0" + (month + 1) + "-" + (dayOfMonth);
                } else if (dayOfMonth < 10) {
                    stDate = (year) + "-" + (month + 1) + "-" + "0" + (dayOfMonth);
                }
                localDate = LocalDate.parse(stDate);
                String event = "    Event on this date: " + map.get(localDate);
                if (map.get(localDate) == null) {
                    event = "    Event on this date: No event added";
                }
                eventOnDate.setText((event));
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

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addEvent() {
        Intent intent = new Intent(this, LaunchActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("localDate", localDate);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
