package com.example.ui_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }
    /*public void sentString(View view){
        EditText edtName = (EditText) findViewById(R.id.edtName);
        String string2Send = edtName.getText().toString();

        //如果要跳到下一頁要寫這個
        Intent intent = new Intent(this, DisplayStringActivity.class);
        //把資料帶過去 接資料用這個變數名稱
        intent.putExtra("userName", string2Send);
        startActivity(intent);
    }*/
    public void sendString(View view){
        EditText edtName = (EditText) findViewById(R.id.edtName);
        String string2Send = edtName.getText().toString();

        Intent intent = new Intent(this, DisplayStringActivity.class);
        intent.putExtra("userName", string2Send);
        startActivity(intent);
    }


}