package com.example.p07_demosimplelistviewexamtips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvExamTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvExamTips = findViewById(R.id.listViewExamTips);

        String [] examTips = {
                            "Don't just read the code, code it as much as possible during each practical session",
                            "Seek help from the lecturer ASAP, don't wait till you lost in the jungle",
                            "Prepare your template source code for each topic",
                            "Create a few empty Android projects to speed up your coding during the exam",
                            "Ensure that your Android Studio is up and running before the exam"
                            };

        ArrayAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,examTips);
        //bind data to listview
        lvExamTips.setAdapter(adapter);
    }
}