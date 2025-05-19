package com.example.hello_spring.controller;

import com.example.hello_spring.domain.Member;
import com.example.hello_spring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/members/new")
    public String showForm() {
        return "register";
    }

    @PostMapping("/members")
    public String register(@RequestParam String name, @RequestParam int age) {
        Member member = new Member();
        member.setName(name);
        member.setAge(age);
        member.setAdult(age >= 20);
        service.save(member);
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String list(Model model) {
        model.addAttribute("members", service.findAll());
        return "members";
    }

    @GetMapping("/members/search")
    public String search(@RequestParam String name, Model model) {
        Member member = service.findByName(name);
        if (member == null) return "redirect:/";
        model.addAttribute("member", member);
        return "member";
    }
}