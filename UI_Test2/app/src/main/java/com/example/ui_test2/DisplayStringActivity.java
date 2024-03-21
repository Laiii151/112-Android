package com.example.ui_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_display_string);

        TextView txvShow = (TextView) findViewById(R.id.txvShow);
        Intent intent = getIntent();
        String receivedString = intent.getStringExtra("userName");
        txvShow.setText(receivedString + " 你好 !");
    }
}