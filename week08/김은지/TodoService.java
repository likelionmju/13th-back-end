package com.example.week08.service;

import com.example.week08.domain.Todo;
import com.example.week08.repository.TodoRepository;
import com.example.week08.repository.TodoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService  {
    TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    //추가
    public Todo register(String todo, int userId) {
        Todo newTodo = new Todo(userId, todo);
        todoRepository.save(newTodo);
        return newTodo;
    }
    //전체조회
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }
    //userId로 찾기
    public List<Todo> getByUserId(int userId) {
        return todoRepository.findByUserId(userId);
    }
    //userId, todo입력 시 완료처리(isCompleted =true)
    public Todo complete(int userId, String todo) {
        return todoRepository.completeTodo(userId, todo);

    }
    //입력된 complete 상태로 조회
    public List<Todo> searchCompleted(boolean tf){
        return todoRepository.returnCompleted(tf);

    }
}
