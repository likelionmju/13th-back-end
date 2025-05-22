package com.example.practice0505.domain;

public class Member {
    private String name;
    private int age;

    public Member() {} // 기본 생성자 (필수)

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public boolean isAdult() {
        return age >= 19;
    }
}
