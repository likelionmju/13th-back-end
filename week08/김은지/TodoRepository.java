package com.example.week08.repository;

import com.example.week08.domain.Todo;

import java.util.List;

public interface TodoRepository {
    void save(Todo todo);
    List<Todo> findAll();
    List<Todo> findByUserId(int userId);
    Todo completeTodo(int userId, String todoText);
    public List<Todo> returnCompleted(boolean tf);
}
