package com.example.scheduler;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class LaunchActivity extends AppCompatActivity {
    LocalDate localDate;
    Map<LocalDate, String> map = EventsName.getInstance().map;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        EditText eventName = findViewById(R.id.eventName);
        eventName.setInputType(InputType.TYPE_CLASS_TEXT);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        localDate = (LocalDate) bundle.getSerializable("localDate");
        Button enter = findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String event = eventName.getText().toString();
                map.put(localDate, event);

                launchGameActivity();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void launchGameActivity() {
        Intent intent = new Intent(this, NewGameActivity.class);
        startActivity(intent);
    }

}
