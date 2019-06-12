package com.example.intents_exercise;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eText;
    EditText eTNumber;
    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eText = findViewById(R.id.write);
        eTNumber = findViewById(R.id.writeNum);
        prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        String result = eText.getText().toString();
        result = prefs.getString("text","");
        eText.setText(result);
    }

    public void buttonOpenPressed(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        String result = eText.getText().toString();
        int resultNum = Integer.parseInt(eTNumber.getText().toString());
        intent.putExtra("text", result);
        intent.putExtra("number", resultNum);
        startActivity(intent);
    }



    public void buttonSharePressed(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String txt = eText.getText().toString();
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, txt);
        startActivity(Intent.createChooser(intent, txt));
    }

    public void buttonEmailPressed(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String txt = eText.getText().toString();
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, txt);
        intent.putExtra(Intent.EXTRA_SUBJECT, txt);
        startActivity(intent);
    }

    public void buttonWebPressed(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String txt = eText.getText().toString();
        intent.setData(Uri.parse(txt));
        startActivity(intent);
    }

    public void buttonMapsPressed(View view) {
        String txt = eText.getText().toString();
        String uri = String.format(txt);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }

    public void buttonSavePressed(View view) {
        SharedPreferences.Editor editor = prefs.edit();
        String result = eText.getText().toString();
        editor.putString("text", result);
        editor.commit();
        result = prefs.getString("text",result);
        eText.setText(result);
    }

    public void buttonTimesPressed(View view){
        Toast.makeText(this, (getString(R.string.timesCounter)+" "+prefs.getInt("counter",0)+" "+(getString(R.string.timesCounter2))), Toast.LENGTH_SHORT).show();
    }
}

