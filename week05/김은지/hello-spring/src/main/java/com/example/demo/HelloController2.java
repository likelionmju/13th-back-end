package com.example.demo;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController2 {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello!!");
        return "hello";
    }
}
