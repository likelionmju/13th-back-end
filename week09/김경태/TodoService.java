package com.example.ll_week09;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    @Autowired
    private final TodoRepository repository;

    public Todo register(Todo todo) {
        todo.setDone("미완료");
        return repository.save(todo);
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo findById(Long Id) {
        return repository.findById(Id).orElse(null);
    }

    public Todo done(Long Id, boolean done) {
        String result;
        Todo target = findById(Id);
        if(done == true) {
            result = "완료";
        }
        else {
            result  = "미완료";
        }
        target.setDone(result);
        return repository.save(target);
    }
}
