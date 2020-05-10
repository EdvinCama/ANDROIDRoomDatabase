package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TodoDetailsActivity extends AppCompatActivity {

    private EditText titleInput;
    private EditText descriptionInput;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_details);
        titleInput = findViewById(R.id.item_title);
        descriptionInput = findViewById(R.id.item_description);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            long id = extras.getLong(MainActivity.EXTRA_TODO_ID);
            Todo todo = AppDatabase.getInstance(this).todoDao().getTodoById(id);
            titleInput.setText(todo.getTitle());
            descriptionInput.setText(todo.getDescription());
        }
    }

    public void onSave(View view){

        Todo todo = new Todo(titleInput.getText().toString(), descriptionInput.getText().toString());
        AppDatabase.getInstance(this).todoDao().add(todo);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onCancel(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
