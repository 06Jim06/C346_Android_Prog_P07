package com.example.p07_simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button btnAdd;
    Button btnClear;
    Button btnDelete;

    ListView lvOutput;

    Spinner SpnAddRemove;

    ArrayList<String> taskList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        btnDelete = findViewById(R.id.buttonDelete);
        lvOutput = findViewById(R.id.view);
        SpnAddRemove = findViewById(R.id.Choice);

        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        lvOutput.setAdapter(adapter);

        SpnAddRemove.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        if (SpnAddRemove.getSelectedItem().toString().equalsIgnoreCase("Add new task")) {
                            input.setText("");
                            input.setHint("Type in new task here");
                        }
                        break;
                    case 1:
                        if (SpnAddRemove.getSelectedItem().toString().equalsIgnoreCase("Remove a task")) {
                            input.setText("");
                            input.setHint("Type in index of the task to be removed");
                        }
                        break;
                    default:
                        input.setHint("Add Task here");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                input.setHint("Please select option to proceed");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = input.getText().toString();
                if (!task.isEmpty()) {
                    taskList.add(task);
                } else {
                    Toast.makeText(MainActivity.this, "Error, task cannot be empty!!", Toast.LENGTH_LONG).show();
                }

                adapter.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posString = input.getText().toString();

                if (!posString.isEmpty()) {
                    int pos = Integer.parseInt(posString);

                    if (pos >= 0 && pos < taskList.size()) {
                        taskList.remove(pos);
                        adapter.notifyDataSetChanged();
                        input.setText("");
                    } else if (taskList.isEmpty()) {
                        Toast.makeText(MainActivity.this, "You don't have any task to remove", Toast.LENGTH_LONG).show();
                        input.setText("");
                        input.setHint("Type in index of the task to be removed");
                    } else {
                        Toast.makeText(MainActivity.this, "Wrong index number!", Toast.LENGTH_LONG).show();
                        input.setText("");
                        input.setHint("Type in index of the task to be removed");
                    }
                }
            }
        });


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
            }
        });
    }
}
