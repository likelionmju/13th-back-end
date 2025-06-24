package com.example.week08.repository;

import com.example.week08.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo>findByUserName(String userName);
    Todo findByUserNameAndTodo(String userName, String todo);
}
