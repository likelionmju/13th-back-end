package com.example.week08.controller;

import com.example.week08.domain.Todo;
import com.example.week08.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Locale;

@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired //생성자 주입
    public TodoController(TodoService todoService) {
        this.todoService = todoService;

    }

    //userId,todo를 입력받아 추가
    @PostMapping("/todos")
    public Todo register(@RequestParam int userId, @RequestParam String todo) {
        return todoService.register(todo, userId);
    }

    //전체 조회
    @GetMapping("/todos")
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    //사용자가 userId와 todo를 입력하면, 완료 처리 해줌 -> 완료 처리 된 tood 객체를 리턴함
    @PostMapping("/todos/complete")
    public Todo complete(@RequestParam int userId, @RequestParam String todo) {
        return todoService.complete(userId, todo);

    }

    //completed 상태로 조회- 필드값 조회
    @GetMapping("/todos/completed")
    public List<Todo> findCompleted(@RequestParam String tf) {
        //소문자로 변환
        tf = tf.toLowerCase();
        if (tf.equals("true") || tf.equals("t")) {
            return todoService.searchCompleted(true);
        } else {
            return todoService.searchCompleted(false);
        }
    }

    //userId로 조회하기-식별값 검색
    @GetMapping("/todos/user")
    public List<Todo> getByUser(@RequestParam int userId) {
        return todoService.getByUserId(userId);
    }


}
