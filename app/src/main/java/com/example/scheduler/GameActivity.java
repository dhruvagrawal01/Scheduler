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
        TextView eventOnDate = findViewById(R.id.eventOnDate);
        String eventName = intent.getStringExtra("eventName");
        String event = "    Event on this date: " + (eventName);
        eventOnDate.setText((event));
    }
}
