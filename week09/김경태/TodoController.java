package com.example.ll_week09;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    public final TodoService todoService;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/register")
    public Todo register(@RequestBody Todo todo){
        return todoService.register(todo);
    }

    @PostMapping("/done")
    public Todo done(@RequestParam Long id, @RequestParam boolean done){
        return todoService.done(id, done);
    }

    @GetMapping("/all")
    public List<Todo> displayAll(){
        return todoService.findAll();
    }

    @GetMapping("/find")
    public Todo findById(@RequestParam Long id){
        return todoService.findById(id);
    }
}
