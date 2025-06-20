package com.example.week08.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class Todo {
    private String todo;
    private boolean isCompleted;
    private LocalDate registerDate;
    private int userId;
    //처음 만들어질 때에는 isCompleted =false
    public Todo(int userId,String todo) {
        this.todo = todo;
        this.isCompleted = false;
        this.userId=userId;
        this. registerDate= LocalDate.now();
    }
//완료 시 isCompleted 상태 변경
    public void setCompleted() {
        this.isCompleted = true;
    }
}
