package com.example.alertdialogchoicedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener{
private String[] items = {"Samsung","OPPO", "Apple", "ASUS"};
private boolean[] itemsChecked = new boolean[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSelect = findViewById(R.id.btnSelect);
        btnSelect.OnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new AlertDialog.Builder(MainActivity.this)
                .setTitle("請勾選選項")
                .setPositiveButton("確定", null)
                .setNegativeButton("取消",null)
                .show();
            }
        });
        }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String msg
    }
}
