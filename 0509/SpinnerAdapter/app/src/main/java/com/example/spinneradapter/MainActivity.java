package com.example.spinneradapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] courses, desserts;
    private Spinner spCourses, spDesserts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses = getResources().getStringArray(R.array.courses);
        desserts = getResources().getStringArray(R.array.desserts);

        spCourses = (Spinner) findViewById(R.id.spinner);
        spDesserts = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> adpCourses = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, courses);
        ArrayAdapter<String> adpDesserts = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, desserts);

        spCourses.setAdapter(adpCourses);
        spDesserts.setAdapter(adpDesserts);

        Button btnComfirm = (Button) findViewById(R.id.button);
        btnComfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course = spCourses.getSelectedItem().toString();
                String dessert = spDesserts.getSelectedItem().toString();
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText("主餐: " + course + "\n甜點: " + dessert);
            }
        });

    }
}