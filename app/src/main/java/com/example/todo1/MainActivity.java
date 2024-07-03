package com.example.todo1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Task> taskList;
    private TaskAdapter taskAdapter;
    private EditText editTextTask;
    private Button buttonAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(taskList);

        editTextTask = findViewById(R.id.editTextTask);
        buttonAddTask = findViewById(R.id.buttonAddTask);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(taskAdapter);

        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = editTextTask.getText().toString();
                if (!taskName.isEmpty()) {
                    taskList.add(new Task(taskName));
                    taskAdapter.notifyItemInserted(taskList.size() - 1);
                    editTextTask.setText("");
                }
            }
        });
    }
}
