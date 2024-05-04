//A111223022
package com.example.buytickets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.buytickets.R;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {
    private TextView output;
    //private EditText edtnumber;
    private int numberOfTickets = 0;
    private String outputStr = "";
    private  String gender  = "";
    private String Type = "";
    //private String outputPrice = "";
    private int price = 0;
    private RadioGroup rg;
    private RadioGroup type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.rgGender);
        type = (RadioGroup) findViewById(R.id.rgType);
        EditText edtNumberOfTickets = (EditText) findViewById(R.id.edtNumberOfTickets);
        // 註冊傾聽者物件
        rg.setOnCheckedChangeListener(this);
        type.setOnCheckedChangeListener(this);
        edtNumberOfTickets.addTextChangedListener(this);
        //num = Integer.parseInt(edtnumber.getText().toString());
        output = (TextView) findViewById(R.id.lblOutput);
        gender = getResources().getString(R.string.male);
        Type = getResources().getString(R.string.regularticket);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Str = "";
                try {
                    String text = getResources().getString(R.string.numberOfTickets);
                    if (rg.getCheckedRadioButtonId() == -1) {
                        Str += "請選擇性別!\n";
                        if(type.getCheckedRadioButtonId() == -1)
                            Str += "請選擇票種!\n";
                    }
                    else if(type.getCheckedRadioButtonId() == -1) {
                        Str += "請選擇票種!\n";
                    }

                    if (!text.isEmpty()) {
                        if (rg.getCheckedRadioButtonId() == -1 || type.getCheckedRadioButtonId() == -1) {
                        }
                        else{
                            // 如果 EditText 和 RadioButton 都有資料，執行跳轉操作
                            Intent intent = new Intent(MainActivity.this, TicketInformationActivity.class);
                            intent.putExtra("outputStr", outputStr);
                            startActivity(intent);
                        }
                    }
                    else{
                        throw new NumberFormatException();
                    }
                    output.setText(Str);
                    output.setTextColor(Color.RED);
                } catch (NumberFormatException e) {
                    Str += "請輸入購買張數!";
                    output.setText(Str);
                    output.setTextColor(Color.RED);
                }
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        TxvShow(rg, rg.getCheckedRadioButtonId());
        TxvShow(type, type.getCheckedRadioButtonId());
    }
    @Override
    public void afterTextChanged(Editable s) {
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        TxvShow(radioGroup, checkedId);
    }

    public void TxvShow(RadioGroup radioGroup, int checkedId){
        //String outputnum = edtnumber.getText().toString();
        String count = getResources().getString(R.string.numberOfTickets);
        String total = getResources().getString(R.string.total);
        // 判斷選擇的 RadioButton
        if (radioGroup.getId() == R.id.rgGender) {
            if (checkedId == R.id.rdbBoy) {
                gender = "Male\n";
            } else if (checkedId == R.id.rdbGirl) {
                gender = "Female\n";
            }
        }
        else if(radioGroup.getId() == R.id.rgType) {
            if (checkedId == R.id.rdbAdult) {
                Type="Regular Ticket\n";
                price = 500;
            } else if (checkedId == R.id.rdbChild) {
                Type="Children Ticket\n";
                price = 250;
            } else {
                Type="Student Ticket\n";
                price = 400;
            }
        }

        if(! count.isEmpty()){
            if(type.getCheckedRadioButtonId() == -1){
                Type = "";
            }
            else if(radioGroup.getId() == R.id.rgType) {
                if (checkedId == R.id.rdbAdult) {
                    total = "\n金額：" + (500 * Integer.parseInt(count));
                } else if (checkedId == R.id.rdbChild) {
                    total = "\n金額：" + (250 * Integer.parseInt(count));
                } else {
                    total = "\n金額：" + (400 * Integer.parseInt(count));
                }
            }
            count = "張數：" + count;
        }
        else{
            total = "";
            count = "";
        }

        //outputStr = outputGen + outputType + count + outputPrice;
        outputStr = String.format("%s%s%s%d%s\n%d",gender,Type,count,numberOfTickets,total,total);
        output.setText(outputStr);
        output.setTextColor(Color.BLACK);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}