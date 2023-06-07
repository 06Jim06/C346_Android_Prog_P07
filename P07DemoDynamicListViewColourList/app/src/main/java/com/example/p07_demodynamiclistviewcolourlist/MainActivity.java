package com.example.p07_demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColour;
    EditText etPosition;

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.edittextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);
        etPosition = findViewById(R.id.position);

        ArrayList<String> alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                if(!etPosition.getText().toString().isEmpty()){
                    int pos = Integer.parseInt(etPosition.getText().toString());
                    alColours.add(pos,colour);
                }
                else{
                    alColours.add(colour);
                }

                adapter.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                pos = Integer.parseInt(etPosition.getText().toString());
                if(etPosition != null){
                    alColours.remove(pos);
                }

                adapter.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                if(etPosition != null){
                    int pos = Integer.parseInt(etPosition.getText().toString());
                    alColours.set(pos,colour);
                }
                else{
                    alColours.add(colour);
                }

                adapter.notifyDataSetChanged();
            }
        });


        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String colour = parent.getItemAtPosition(position).toString();
               Toast.makeText(MainActivity.this, colour, Toast.LENGTH_LONG).show();
            }
        });
    }
}