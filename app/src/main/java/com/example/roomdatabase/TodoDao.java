package com.example.roomdatabase;


import android.widget.LinearLayout;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {

@Insert
void add(Todo todo);

@Query("SELECT * FROM todos")
List<Todo> getall();

@Query("SELECT * FROM todos WHERE id = :id LIMIT 1")
Todo getTodoById(long id);

}
