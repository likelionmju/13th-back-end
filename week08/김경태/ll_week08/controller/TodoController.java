package com.example.ll_week08.controller;

import com.example.ll_week08.repository.Todo;
import com.example.ll_week08.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    public final TodoService todoService;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/register")
    public Todo register(@RequestParam int id, @RequestParam int date, @RequestParam String todo){
        return todoService.register(id, date, todo);
    }

    @PostMapping("/done")
    public Todo done(@RequestParam int id, @RequestParam boolean done){
        return todoService.done(id, done);
    }

    @GetMapping("/all")
    public List<Todo> displayAll(){
        return todoService.findAll();
    }

    @GetMapping("/find")
    public Todo findById(@RequestParam int id){
        return todoService.findById(id);
    }
}
