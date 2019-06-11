package com.example.intents_exercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText eText;
    EditText eTNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eText= findViewById(R.id.write);
        eTNumber = findViewById(R.id.writeNum);
    }
    public void buttonOpenPressed (View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        String result = eText.getText().toString();
        String resultNumText = eTNumber.getText().toString();
        int resultNum= Integer.parseInt(resultNumText);
        intent.putExtra("text", result);
        intent.putExtra("number", resultNum);
        startActivity(intent);
    }
}

