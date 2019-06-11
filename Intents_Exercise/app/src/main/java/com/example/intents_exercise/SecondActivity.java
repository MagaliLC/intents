package com.example.intents_exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvResult = findViewById(R.id.text);

        String text = getIntent().getStringExtra("text");
        int number = getIntent().getIntExtra("number",0);

        tvResult.setText(text+ " " + number);

    }

}
