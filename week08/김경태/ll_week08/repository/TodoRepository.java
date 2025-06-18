package com.example.ll_week08.repository;

import java.util.List;

public interface TodoRepository {
    Todo save(Todo todo);
    Todo findById(int id);
    Todo done(int id, String result);
    List<Todo> findAll();
}
