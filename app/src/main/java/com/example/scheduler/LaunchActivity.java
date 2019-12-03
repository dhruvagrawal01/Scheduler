package com.example.scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        EditText eventName = findViewById(R.id.eventName);
        String event = eventName.getText().toString();
        Button enter = findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNewGameActivity(event);
            }
        });
    }
    public void launchNewGameActivity(String event) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("eventName", event);
        startActivity(intent);
        finish();
    }

}
