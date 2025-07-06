package com.example.spring_project.controller;

public class MemberForm {
    private String name;
    private int age;
    private String email;
    private boolean allergyInfo;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // Getter/Setter: email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter/Setter: allergyInfo
    public boolean isAllergyInfo() {
        return allergyInfo;
    }
    public void setAllergyInfo(boolean allergyInfo) {
        this.allergyInfo = allergyInfo;
    }
}