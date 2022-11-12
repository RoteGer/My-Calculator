package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String str = intent.getStringExtra("key1");

        result = findViewById(R.id.textView2);

        result.setText(str);
    }
}
