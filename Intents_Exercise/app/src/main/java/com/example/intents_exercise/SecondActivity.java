package com.example.intents_exercise;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvResult;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvResult = findViewById(R.id.text);
        prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        String text = getIntent().getStringExtra("text");
        int number = getIntent().getIntExtra("number",0);

        tvResult.setText(text+ " " + number);

        int counter = prefs.getInt("counter",0);
        counter++;

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("counter", counter);
        editor.commit();

    }

}
