package com.example.week06_hw.domain;

public class Member { //회원 데이터를 담는 곳
    //나이, 이름만 가지고 판별
    private String name;
    private int age;

    //생성자, Member 호출 시 이름과 나이를 지정
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //성인, 미자 판별하는 메소드
    public boolean isAdult() {
        if (age >= 20) { //성인이면 true
            return true;
        }
        return false; //미자면 false
    }

}
