package com.example.alertdialogchoicedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    private TextView Output;
    private String[] items = {"Samsung", "OPPO", "Apple", "ASUS"};
    private boolean[] itemsChecked = new boolean[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSelect = findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("請勾選選項?");
                builder.setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        itemsChecked[which] = isChecked;
                    }
                });
                builder.setPositiveButton("確定", MainActivity.this);
                builder.setNegativeButton("取消", MainActivity.this);
                builder.show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String msg = "";
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                for (int i = 0; i < items.length; i++) {
                    if (itemsChecked[i]) {
                        msg += items[i] + "\n";
                    }
                }
                TextView output = findViewById(R.id.lblOutput);
                output.setText(msg);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(MainActivity.this, "按下取消鍵", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
