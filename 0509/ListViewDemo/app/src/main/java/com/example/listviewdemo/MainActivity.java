package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView lvcities;
    private String[] cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = getResources().getStringArray(R.array.cities);
        lvcities = (ListView) findViewById(R.id.listview);

        /*ArrayAdapter<String> adpCities = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, cities);*/

        //lvcities.setAdapter(adpCities);
        lvcities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String city = (String) parent.getItemAtPosition(position);
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText("你是住在: " + cities[position]);
                Toast.makeText(MainActivity.this, "你是住在: " + city, Toast.LENGTH_SHORT).show();
            }
        });
    }
}