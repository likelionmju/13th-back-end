package com.example.week08.controller;

import com.example.week08.domain.Todo;
import com.example.week08.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired //생성자 주입
    public TodoController(TodoService todoService) {
        this.todoService = todoService;

    }

    //userId,todo를 입력받아 추가
    @PostMapping("/todos")
    public Todo register(@RequestBody Todo todo) {
        return todoService.register(todo);
    }

    //전체 조회
    @GetMapping("/todos")
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    //사용자가 userId와 todo를 입력하면, 완료 처리 해줌 -> 완료 처리 된 tood 객체를 리턴함
    @PostMapping("/todos/complete")
    public Todo complete(@RequestParam String userName, @RequestParam String todo) {
        return todoService.complete(userName, todo);

    }

    //userName으로 조회하기-식별값 검색
    @GetMapping("/todos/user")
    public List<Todo> getByUserName(@RequestParam String userName) {
        return todoService.getByUserName(userName);
    }

    @GetMapping("/todos/key")
    public Optional<Todo> findById (@RequestParam Long id) {
        return todoService.findById(id);
    }
}
