package com.example.p07_demospinnertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Spinner spnYesNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        spnYesNo = findViewById(R.id.spinner);

        spnYesNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String yes = "Spinner Item, yes selected";
                String no = "Spinner Item, no selected";
                switch (position){
                    case 0:
                        if(spnYesNo.getSelectedItem().toString().equalsIgnoreCase("yes")) {
                            tv.setText(yes);
                        }
                        break;
                    case 1:
                        if(spnYesNo.getSelectedItem().toString().equalsIgnoreCase("no")) {
                            tv.setText(no);
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}