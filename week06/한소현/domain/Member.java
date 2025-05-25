package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {
    private String name;
    private int age;
    private Long id;
    private boolean isAdult;

    public void setAge(int age) {
        this.age = age;
        setAdult(readerIsAdult(age));
    }

   public boolean readerIsAdult(int age){
       return age > 19;
   }
}
