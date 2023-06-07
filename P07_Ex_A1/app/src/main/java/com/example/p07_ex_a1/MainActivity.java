package com.example.p07_ex_a1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    String output ="";
    String theFruit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Array");

        String[] fruits;
        fruits = new String[4];
        fruits[0] = "apple";
        fruits[1] = "banana";
        fruits[2] = "cherry";
        fruits[3] ="durian";
        output = "Fruits\n====\n";

        ArrayList<String> fruitList = new ArrayList<String>();

        for(int i=0;i< fruits.length;i++){
            fruitList.add(fruits[i]);
            output += fruitList.get(i) + "\n";

        }

        tv = findViewById(R.id.textView);

//        for(int i=0;i<fruits.length;i++){
//            output += fruits[i]+"\n";
//        }
        tv.setText(output);
        //retrieve second element
        theFruit = fruitList.get(1);
        //remove first element
        fruitList.remove(0);
        //last element to change to dragon fruit
        fruitList.set(fruitList.size()-1,"dragon fruit");
    }
}