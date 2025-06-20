package com.example.ll_week08.service;

import com.example.ll_week08.repository.Todo;
import com.example.ll_week08.repository.TodoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepositoryImpl todoRepositoryImpl;

    @Autowired
    public TodoService(TodoRepositoryImpl todoRepositoryImpl) {
        this.todoRepositoryImpl = todoRepositoryImpl;
    }


    public Todo register(int id, int date, String work){
        Todo todo = new Todo();
        todo.setId(id);
        todo.setDate(date);
        todo.setTodo(work);
        todo.setDone("미완료");
        return todoRepositoryImpl.save(todo);
    }

    public Todo done(int id, boolean done){
        String result;
        if(done == true){
            result = "완료";
        }
        else{
            result = "미완료";
        }
        return todoRepositoryImpl.done(id, result);
    }

    public Todo findById(int id){
        return todoRepositoryImpl.findById(id);
    }

    public List<Todo> findAll(){
        return todoRepositoryImpl.findAll();
    }
}
