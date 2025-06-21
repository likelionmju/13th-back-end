package com.example.week08.service;

import com.example.week08.domain.Todo;
import com.example.week08.repository.TodoRepository;
//import com.example.week08.repository.TodoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //추가
    public Todo register(Todo todo) {
       todo.setCompleted(false);
       todo.setRegisterDate(LocalDate.now());
        return todoRepository.save(todo);
    }

    //전체조회
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }
    //optional:값이 없을 때 꺼내면 NullPointerException날 수 있으니 방지하기 위함(?)
    public Optional<Todo> findById(Long id){
        return todoRepository.findById(id);
    }
    //userId로 찾기 - 필드값으로 찾기
    public List<Todo> getByUserName(String userName) {
        return todoRepository.findByUserName(userName);
    }

    //userId, todo입력 시 완료처리(isCompleted =true)
    public Todo complete(String userName, String todo) {
        Todo target = todoRepository.findByUserNameAndTodo(userName,todo);
        if(target==null) {
            return null;
        }
        target.setCompleted(); //complete 상태를 true 로 변경
        return todoRepository.save(target);

    }

}
