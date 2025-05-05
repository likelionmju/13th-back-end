package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")//기본경로
public class HelloController {
    @GetMapping("/hi") //그 밑 경로
    public String hello(){
        return "Hello likelion!";
    }
}
